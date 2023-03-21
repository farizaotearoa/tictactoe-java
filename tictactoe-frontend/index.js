window.addEventListener('DOMContentLoaded', () => {
    const tiles = Array.from(document.querySelectorAll('.tile'));
    const playerDisplay = document.querySelector('.display-player');
    const resetButton = document.querySelector('#reset');
    const announcer = document.querySelector('.announcer');

    let board = {
        "0":null,
        "1":null,
        "2":null,
        "3":null,
        "4":null,
        "5":null,
        "6":null,
        "7":null,
        "8":null,
    }
    let currentPlayer = 'X';
    let isGameOver = false;
    let gameState;

    function changeBoard(newBoard) {
        board[0] = newBoard[0];
        board[1] = newBoard[1];
        board[2] = newBoard[2];
        board[3] = newBoard[3];
        board[4] = newBoard[4];
        board[5] = newBoard[5];
        board[6] = newBoard[6];
        board[7] = newBoard[7];
        board[8] = newBoard[8];
    }

    const announce = (type) => {
        switch(type){
            case 'O':
                announcer.innerHTML = 'Player <span class="playerO">O</span> Won';
                break;
            case 'X':
                announcer.innerHTML = 'Player <span class="playerX">X</span> Won';
                break;
            case 'Draw':
                announcer.innerText = 'Draw';
        }
        announcer.classList.remove('hide');
    };

    function isValidAction(tile){
        if (tile.innerText === 'X' || tile.innerText === 'O'){
            return false;
        }
        return true;
    };

    function changePlayer() {
        playerDisplay.classList.remove(`player${currentPlayer}`);
        currentPlayer = currentPlayer === 'X' ? 'O' : 'X';
        playerDisplay.innerText = currentPlayer;
        playerDisplay.classList.add(`player${currentPlayer}`);
    }

    const userAction = (tile, index) => {
        if(isValidAction(tile) && !isGameOver) {
            tile.innerText = currentPlayer;
            tile.classList.add(`player${currentPlayer}`);
            const bodyReq = JSON.stringify({
                currentBoard : board,
                player: currentPlayer,
                position : index.toString()
            });
            fetch("http://localhost:8080/api/v1/tictactoe/turn", {
                method: "POST",
                body: bodyReq,
                headers: {
                    "Content-type": "application/json; charset=UTF-8"
                }
            })
            .then((response) => response.json())
            .then((json) => callbackTurn(json));
        }
    }

    function callbackTurn(response) {
        gameState = response;
        changeBoard(gameState.board)
        if (gameState.gameOver === false) {
            changePlayer();
        } else {
            announce(gameState.winner);
            isGameOver = true;
        }
    }

    const resetBoard = () => {
        fetch("http://localhost:8080/api/v1/tictactoe/reset")
            .then((response) => response.json())
            .then((json) =>  callbackReset(json));
    }

    function callbackReset(response) {
        gameState = response;
        changeBoard(gameState.board);

        isGameOver = gameState.gameOver;
        announcer.classList.add('hide');

        if (currentPlayer === 'O') {
            changePlayer();
        }
        tiles.forEach(tile => {
            tile.innerText = '';
            tile.classList.remove('playerX');
            tile.classList.remove('playerO');
        });
    }

    tiles.forEach( (tile, index) => {
        tile.addEventListener('click', () => userAction(tile, index));
    });

    resetButton.addEventListener('click', resetBoard);
});