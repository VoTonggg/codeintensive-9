package players;

import bases.Vector2D;
import inputs.InputManager;

public class Player2Move {
    void run(Vector2D position) {
        position.x = InputManager.instance.mouseX;
        position.y = InputManager.instance.mouseY;
    }
}
