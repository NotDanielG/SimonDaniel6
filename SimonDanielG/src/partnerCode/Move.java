package partnerCode;

import guiSimon.components.ButtonInterfaceDaniel;
import guiSimon.components.MoveInterfaceDaniel;

public class Move implements MoveInterfaceDaniel {
	private ButtonInterfaceDaniel b;
	public Move(ButtonInterfaceDaniel b){
		this.b = b;
	}
	public ButtonInterfaceDaniel returnButton() {
		return b;
	}

}
