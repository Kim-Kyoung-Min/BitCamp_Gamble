package gamble;
//package game;

import java.io.IOException;

public class Shop {

	private int apple;
	private int gem;
	private int b;

	Shop() {
		apple = 1;
		gem = 1;
	}

	public void itemStore() throws IOException, InterruptedException {
		while (true) {

			System.err.print("로딩�?");
			String load = "./.|";
			for (int i = 0; i < 20; i++) {
				String data = load.charAt(i % load.length()) + "";
				System.err.write(data.getBytes());

				Thread.sleep(20);

			}

			System.err.println("?���?");
			System.out.println("====?��?��?�� ?��?��?��?��?��~!====");
			System.out.println("[1]?���? 1$- ?��?�� �? 체력 10?���?");
			System.out.println("[2]보석 2$- ?��?�� �? 마나 2?���?");
			System.out.println("[3]?���?�?");
			System.out.println("======================");
			System.out.print("?��?��>>");

			int a = View.sc.nextInt();
			if (a != 3) {
				System.out.print("�??��>>");
				b = View.sc.nextInt();
			} else {
				return;
			}
			switch (a) {
			case 1:
				// is[0]= new itemStorage(i.apple+curCnt*b,i.gem);
				if (Character.coin > 0) {
					Character.apple += (apple * b);
					if (Character.coin >= 1 * b) {
						Character.coin -= 1 * b;
						System.out.printf("?��과�?? %d�? 구매?��???��?��?��.\n", b);
					} else {
						System.out.println("코인?�� �?족합?��?��");
					}
				} else {
					System.out.println("코인?�� �?족합?��?��");
				}
				break;
			case 2:
				// is[0]= new itemStorage(i.apple,i.gem+curCnt*b);

				if (Character.coin > 1) {
					if (Character.coin >= 2 * b) {
						Character.coin -= 2 * b;
						System.out.printf("보석?�� %d�?  구매?��???��?��?��.\n", b);
					}
					else {
						System.out.println("코인?�� �?족합?��?��");
					}
					
				} else {
					System.out.println("코인?�� �?족합?��?��");
				}
				break;
			default:
				break;
			}

		}
	}
}
