package io;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;

import worldInit.World;
import display.SpriteWorld;

public class KeyEventDispatcherAstro implements KeyEventDispatcher {

	public boolean dispatchKeyEvent(KeyEvent e) {
		if (e.getID() == KeyEvent.KEY_PRESSED) {
			keyPressTreat(e);
		}

		else if (e.getID() == KeyEvent.KEY_RELEASED) {
		}

		else if (e.getID() == KeyEvent.KEY_TYPED) {
		}
		return false;
	}

	public void keyPressTreat(KeyEvent e) {

		int c = e.getKeyCode();

		switch (c) {

		case KeyEvent.VK_UP:
			World.addYOffSet(-1);
			break;

		case KeyEvent.VK_DOWN:
			World.addYOffSet(1);
			break;

		case KeyEvent.VK_LEFT:
			World.addXOffSet(-1);
			break;

		case KeyEvent.VK_RIGHT:
			World.addXOffSet(1);
			break;

		case KeyEvent.VK_F1:
			SpriteWorld.setSpriteLength(SpriteWorld.getSpriteLength() + 8);
			break;

		case KeyEvent.VK_F2:
			SpriteWorld.setSpriteLength(SpriteWorld.getSpriteLength() - 8);
			break;

		case KeyEvent.VK_ESCAPE:
			break;

		}
	}

}
