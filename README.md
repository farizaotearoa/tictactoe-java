# Tic-tac-toe Java

I'm creating tic-tac-toe game using Java Spring Boot as backend. For the frontend i'm modifying code from https://dev.to/javascriptacademy/create-a-simple-tic-tac-toe-game-using-html-css-javascript-i4k

# How to Run

1. Go to **tictactoe** folder and then run
   ```bash
   mvn spring-boot:run
   ```

2. Open file **index.html** inside **tictactoe-frontend** folder

​		<img width="609" alt="image" src="https://user-images.githubusercontent.com/25082101/226620538-d6c0ff06-234e-4482-a840-183df9caba92.png">



# Endpoints

## 1. /reset (GET Method)

Reset the tictactoe game board state to initial state

Sample Response: 

```json
{
    "gameOver": false,
    "winner": "",
    "board": {
        "0": null,
        "1": null,
        "2": null,
        "3": null,
        "4": null,
        "5": null,
        "6": null,
        "7": null,
        "8": null,
        "9": null
    }
}
```

## 2. /turn (POST Method)

Player take turn in tictactoe game

### Case 1. First game move

**Sample Request Body**

```json
{
    "player":"X",
    "position":"0",
    "currentBoard": {
        "0": null,
        "1": null,
        "2": null,
        "3": null,
        "4": null,
        "5": null,
        "6": null,
        "7": null,
        "8": null,
        "9": null
    }
}
```

**Sample Response**

```json
{
    "gameOver": false,
    "winner": "",
    "board": {
        "0": "X",
        "1": null,
        "2": null,
        "3": null,
        "4": null,
        "5": null,
        "6": null,
        "7": null,
        "8": null,
        "9": null
    }
}
```



### Case 2. Player X won the game

[ X , X , - ]	-->	   [ X , X , X ]	

[ O , O , - ]	-->      [ O , O , - ]

[ - , - , - ]	-->      [ - , - , - ]

**Sample Request Body**

```json
{
    "player":"X",
    "position":"2",
    "currentBoard": {
        "0": "X",
        "1": "X",
        "2": null,
        "3": "O",
        "4": "O",
        "5": null,
        "6": null,
        "7": null,
        "8": null,
        "9": null
    }
}
```

**Sample Response**

```json
{
    "gameOver": true,
    "winner": "X",
    "board": {
        "0": "X",
        "1": "X",
        "2": "X",
        "3": "O",
        "4": "O",
        "5": null,
        "6": null,
        "7": null,
        "8": null,
        "9": null
    }
}
```

