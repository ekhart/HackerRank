// Power of Thor - Episode 1
// https://www.codingame.com/ide/puzzle/power-of-thor-episode-1

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 * ---
 * Hint: You can use the debug stream to print initialTX and initialTY, if Thor seems not follow your orders.
 **/

var inputs = readline().split(' ');
var lightX = parseInt(inputs[0]); // the X position of the light of power
var lightY = parseInt(inputs[1]); // the Y position of the light of power
var initialTX = parseInt(inputs[2]); // Thor's starting X position
var initialTY = parseInt(inputs[3]); // Thor's starting Y position

var thorX = initialTX;
var thorY = initialTY;

// x, y
var direction = { 
    "-1": { "-1": "NW", "0": "W", "1": "SW" },
    "0":  { "-1": "N",  "0": "",  "1": "S" },
    "1":  { "-1": "NE", "0": "E", "1": "SE" }
};

// game loop
while (true) {
    var remainingTurns = parseInt(readline()); // The remaining amount of turns Thor can move. Do not remove this line.

    // Write an action using print()
    // To debug: printErr('Debug messages...');
    printErr("remainingTurns = " + remainingTurns);

    var diffX, diffY;
    if (lightX < thorX) {
        diffX = -1;
    } else if (lightX > thorX) {
        diffX = 1;
    } else {
        diffX = 0;
    }
    printErr("diffX = " + diffX);
    thorX += diffX;
    
    if (lightY < thorY) {
        diffY = -1;
    } else if (lightY > thorY) {
        diffY = 1;
    } else {
        diffY = 0;
    }
    printErr("diffY = " + diffY);
    thorY += diffY;

    // A single line providing the move to be made: N NE E SE S SW W or NW
    print(direction[diffX+""][diffY+""]);
}