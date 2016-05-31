package hanoi;

import java.util.ArrayList;

public class hanoi2 {

	private static int TOWER_STAGE = 10;
	private static ArrayList<Integer> lef = new ArrayList<Integer>();
    private static ArrayList<Integer> cen = new ArrayList<Integer>();
    private static ArrayList<Integer> rig = new ArrayList<Integer>();
	static int cnt = 1;

	/*
	 * 塔の最少数を調べる
	 * */
    private static int min(ArrayList<Integer> number) {

        int min = number.get(0);
        for (int i = 1; i < number.size(); i++){
            min = Math.min(min, number.get(i));
        }
        return min;
    }

    /*移動する場所を表示*/
    private static void move(int a, String b, String c){
        System.out.println(a + "を" + b + "から" + c + "に動かします");
    }

    /*
     * 一番小さい場所を動かすプログラム
     * tow = 塔の最大数
     * min = 塔の最少数
     * */
    private static void oneMove(int tow, int min) {
    	// 塔が偶数の場合
    	if(tow % 2 == 0) {
    		if (cnt == 1) {
    			move(min, "A", "B");
                lef.remove(lef.indexOf(min));
                cen.add(min);
                cnt++;
    		}
    		else if (cnt == 2) {
    			move(min, "B", "C");
    			cen.remove(cen.indexOf(min));
    			rig.add(min);
                cnt++;
    		}
    		else if (cnt == 3) {
    			move(min, "C", "A");
                rig.remove(rig.indexOf(min));
                lef.add(min);
                cnt = 1;
    		}

    	}
    	// 塔が奇数の場合
    	else {
    		if (cnt == 1) {
    			move(min, "A", "C");
                lef.remove(lef.indexOf(min));
                rig.add(min);
                cnt++;
    		}
    		else if (cnt == 2) {
    			move(min, "C", "B");
    			rig.remove(rig.indexOf(min));
    			cen.add(min);
                cnt++;
    		}
    		else if (cnt == 3) {
    			move(min, "B", "A");
    			cen.remove(cen.indexOf(min));
                lef.add(min);
                cnt = 1;
    		}

    	}

    }

    /*
     * 最少数がある塔以外の最少数を動かす
     * */
    private static void towMove( int sml) {
    	// 左の塔に最少数がある場合
    	if(lef.contains(sml) == true) {
            if (rig.size() > 0) {
                if (cen.size() > 0) {
                    if (min(cen) > min(rig)) {
                        // C -> B
                        move(min(rig), "C", "B");
                        cen.add(min(rig));
                        rig.remove(rig.indexOf(min(rig)));
                    } else {
                        // B -> C
                        move(min(cen), "B", "C");
                        rig.add(min(cen));
                        cen.remove(cen.indexOf(min(cen)));
                    }
                } else {
                    // C -> B
                    move(min(rig), "C", "B");
                    cen.add(min(rig));
                    rig.remove(rig.indexOf(min(rig)));
                }
            } else {
                // B -> C
                move(min(cen), "B", "C");
                rig.add(min(cen));
                cen.remove(cen.indexOf(min(cen)));
            }
    	}
    	// 中央の塔に最少数がある場合
        if(cen.contains(sml) == true) {
            if (rig.size() > 0) {
                if (lef.size() > 0) {
                    if (min(lef) > min(rig)) {
                        // C -> A
                        move(min(rig), "C", "A");
                        lef.add(min(rig));
                        rig.remove(rig.indexOf(min(rig)));
                    } else {
                        // A -> C
                        move(min(lef), "A", "C");
                        rig.add(min(lef));
                        lef.remove(lef.indexOf(min(lef)));
                    }
                } else {
                    // C -> A
                        move(min(rig), "C", "A");
                        lef.add(min(rig));
                        rig.remove(rig.indexOf(min(rig)));
                }
            } else {
                // A -> C
                move(min(lef), "A", "C");
                rig.add(min(lef));
                lef.remove(lef.indexOf(min(lef)));
            }
        }
    	// 右の塔に最少数がある場合
        if(rig.contains(sml) == true) {
            if (cen.size() > 0) {
                if (lef.size() > 0) {
                    if (min(lef) > min(cen)) {
                        // B -> A
                        move(min(cen), "B", "A");
                        lef.add(min(cen));
                        cen.remove(cen.indexOf(min(cen)));
                    } else {
                        // A -> B
                        move(min(lef), "A", "B");
                        cen.add(min(lef));
                        lef.remove(lef.indexOf(min(lef)));
                    }
                } else {
                    // B -> A
                        move(min(cen), "B", "A");
                        lef.add(min(cen));
                        cen.remove(cen.indexOf(min(cen)));
                }
            } else {
                // A -> B
                move(min(lef), "A", "B");
                cen.add(min(lef));
                lef.remove(lef.indexOf(min(lef)));
            }
        }

    }

	static void hanoi(int n,String t1, String t2, String t3) {
		if (n > 0) {
//		    hanoi(n - 1, t1, t3, t2);
		    System.out.println(n + "番目を" + t1 + "から" + t3 + "へ移動する。");
//		    hanoiMove(n,t1,t3);
		    hanoi(n - 1, t2, t1, t3);
		}
	}

	public static void main (String[] args) {
		int tow = TOWER_STAGE;
		System.out.println(tow + "段のハノイの塔開始");
        for (int i = tow; i > 0; i--) {
        	lef.add(i);
        }
		int sml = min(lef);
		int count = 1;
        while (rig.size() != tow) {
            System.out.println("[ " + count + "回目 ]A ");
            oneMove(tow, sml);
            System.out.print(lef);
            System.out.print(cen);
            System.out.println(rig);
            count++;
            if(count == 500) {
            	count = 500;
            }
            if (rig.size() != tow) {
	            System.out.println("[ " + count + "回目 ]B ");
	            towMove(sml);
	            System.out.print(lef);
	            System.out.print(cen);
	            System.out.println(rig);
	            count++;
            }
            if(count == 500) {
            	count = 500;
            }

        }
		System.out.println(TOWER_STAGE + "段のハノイの塔終了");
	}
}
