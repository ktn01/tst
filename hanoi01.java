package hanoi;

public class hanoi01 {

	private static int TOWER_STAGE = 10;
	private static int lef[] = new int[TOWER_STAGE];
	private static int cen[] = new int[TOWER_STAGE];
	private static int rig[] = new int[TOWER_STAGE];
	static int cnt = 0;

	static void hanoiMove(int n, String t1, String t3) {

		int x = 0;
		if (t1.equals("LEFT")&&t3.equals("CENTER")) {
			x = lef[n-1];
			lef[n-1] = cen[n-1];
			cen[n-1] = x;
		}
		if (t1.equals("LEFT")&&t3.equals("RIGHT")) {
			x = lef[n-1];
			lef[n-1] = rig[n-1];
			rig[n-1] = x;
		}
		if (t1.equals("CENTER")&&t3.equals("LEFT")) {
			x = cen[n-1];
			cen[n-1] = lef[n-1];
			lef[n-1] = x;
		}
		if (t1.equals("CENTER")&&t3.equals("RIGHT")) {
			x = cen[n-1];
			cen[n-1] = rig[n-1];
			rig[n-1] = x;
		}
		if (t1.equals("RIGHT")&&t3.equals("LEFT")) {
			x = rig[n-1];
			rig[n-1] = lef[n-1];
			lef[n-1] = x;
		}
		if (t1.equals("RIGHT")&&t3.equals("CENTER")) {
			x = rig[n-1];
			rig[n-1] = cen[n-1];
			cen[n-1] = x;
		}
		for (int i = 0 ; i < TOWER_STAGE ; i++) {
			System.out.print(" "+String.format("%1$2d",lef[i]));
			System.out.print(" "+String.format("%1$2d",cen[i]));
			System.out.println(" "+String.format("%1$2d",rig[i]));
		}

	}

	static void hanoi(int n,String t1, String t2, String t3) {
		if (n > 0) {
		    hanoi(n - 1, t1, t3, t2);
		    System.out.println(n + "番目を" + t1 + "から" + t3 + "へ移動する。");
		    hanoiMove(n,t1,t3);
		    hanoi(n - 1, t2, t1, t3);
		}
	}

	public static void main (String[] args) {
		System.out.println(TOWER_STAGE + "段のハノイの塔開始");
		for (int i = 0 ; i < TOWER_STAGE ; i++) {
			lef[i] = i+1;
			cen[i] = 0;
			rig[i] = 0;
		}		hanoi(TOWER_STAGE, "LEFT", "CENTER", "RIGHT");
		System.out.println(TOWER_STAGE + "段のハノイの塔終了");
	}
}
