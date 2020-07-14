package gamble;
import java.io.IOException;
import java.util.Random;

public class MonsterBoss extends Monster {

	private double dice = 0;
	private String[] reword;

	MonsterBoss() {
		this.hp = 50;
		this.reword = null;
	}

	public int getExp() {
		return exp;
	}
	public int getCoin() {
		return coin;
	}

	public int mAttackDamageRandom() {
		return this.attackDamage = View.rd.nextInt(6)+10;
	}

	public int monsterHp() {
		return hp;
	}

	public boolean subHp(int hp) {
		this.hp = hp;

		if (this.hp <= 0) {
			return false;
		} else if (this.hp >= 5000) {
			System.out.println("보스: 넌 안보내준다");
			
		}
		return true;
	}

	public int battleAttack(int userHp) throws InterruptedException {
		mAttackDamageRandom();
		mAttackSound();
		userHp = userHp -attackDamage;
		System.out.printf("%d데미지를 입혔습니다\n", attackDamage);
		if (userHp > 0) {
			System.out.printf("유저의 hp가 %d 남았습니다\n", userHp);
		} else if (userHp <= 0) {
			System.out.println("유저의 체력이 0이 되었습니다.");
			System.err.println("회복하고 다시 도전하세요");
		}
		return userHp;
	}

	public void mAttackSound() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("쿵!!");
	}

	public String[] getReword() throws IOException {
		AscillArtReword ar = new AscillArtReword();
		ar.reword01();
		ar.reword02();
		double i = Math.random();
		if (i <= 0.5) {
			this.reword = ar.ReaderV();
			System.out.println("브이 그림을 획득했습니다");
			return reword;
		}
		if(i>0.5) {
			this.reword=ar.ReaderLike();
			System.out.println("따봉 그림을 획득했습니다");
			return reword;
		}

		return null;
	}

}
