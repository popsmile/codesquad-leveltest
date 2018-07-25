package level2;

import java.util.Random;
import java.util.Scanner;

public class NumberBaseballGame {

	public static void main(String[] args) {
        	NumberBaseballGame nbs = new NumberBaseballGame();
        	int[] answer = nbs.makeAnswer();
       		while(true) {
    	   		int[] strikeBall = nbs.doGame(answer);
	       		System.out.println(nbs.showResult(strikeBall[0], strikeBall[1]));
	       		if(strikeBall[0]==3) break;
       		}
	}

	public int[] makeAnswer() {
		Random random = new Random();
		int[] answer = new int[3];
		for(int i=0; i<answer.length; i++) {
			answer[i] = random.nextInt(9) + 1;
			i = removeSameValuePosition(i, answer);
		}
		return answer;
	}
	
	public int removeSameValuePosition(int i, int[] answer) {
		for(int j=0; j<i; j++) {
			if(answer[i]==answer[j]) {
				i--;
				break;
			}
		}
		return i;
	}
	
	public int[] getUserGuess() {
		System.out.print("숫자를 입력해주세요 ex)123 : ");
		int[] guess = new int[3];
        	Scanner sc = new Scanner(System.in);
        	int guessInput = sc.nextInt();
        	for(int i=0; i<guess.length; i++) {
        		guess[guess.length-i-1] = guessInput%10;
        		guessInput = guessInput/10;
        	}
        	return guess;
	}
	
	public boolean isStrike(int guess, int answer){
		if(guess==answer) return true;
		else return false;
	}
	
	public boolean isBall(int guess, int[] answer){
		for(int i=0; i<answer.length; i++){
			if(guess==answer[i]) return true;
		}
		return false;
	}
	
	public String showResult(int strike, int ball) {
		if(strike==3) return "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
		else if(strike==0 && ball==0) return "낫싱";
		else if(ball==0) return strike + "스트라이크";
		else if(strike==0) return ball + "볼";
		else return strike + "스트라이크 " + ball + "볼";
	}
	
	public int[] doGame(int[] answer) {
		int[] guess = getUserGuess();
		int[] strikeBall = new int[2];
		for(int i=0; i<guess.length; i++) {
			if(isStrike(guess[i],answer[i])==true) {
				strikeBall[0]++;
				continue;
			}
			else if(isBall(guess[i],answer)==true) { strikeBall[1]++; }
		}
		return strikeBall;
	}

}
