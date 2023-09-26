package main.practice20230410.question15;

public class InheritanceInterfacePractice {

	public static void main(String[] args) {
		  // ミュージシャン配列の作成
        Musician[] band = {
                    new Vocalist("桜井"),
                    new Guitarist("田原", "リードギター"),
                    new Guitarist("中川", "ベース"),
                    new ChorusDrummer("鈴木")
        };
        // ミュージックスタート！

        for(Musician music : band) {
        	if(music instanceof Singable) {
        		((Singable) music).sing();
        	}
        	if(music instanceof Playable) {
        		((Playable) music).play();
        	}
        }

	}

}
