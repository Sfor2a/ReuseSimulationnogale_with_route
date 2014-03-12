package simulation;

import housedata.HAdata;
import housedata.Housedata;

public class Score {
	private int ScoreforBuy; //�������̃X�R�A
	private int ScoreforSell; //���鑤�̃X�R�A
	private Housedata BuyHouse; //�������̉�
	private Housedata SellHouse; //���鑤�̉�
	private HAdata SellHA; //���邽�߂̉Ƌ�
	private int Dist; //����
	
	//�Q�b�^�[�E�Z�b�^�[
	public int getScoreforBuy() {
		return ScoreforBuy;
	}
	public void setScoreforBuy(int scoreforBuy) {
		ScoreforBuy = scoreforBuy;
	}
	public int getScoreforSell() {
		return ScoreforSell;
	}
	public void setScoreforSell(int scoreforSell) {
		ScoreforSell = scoreforSell;
	}
	public Housedata getBuyHouse() {
		return BuyHouse;
	}
	public void setBuyHouse(Housedata buyHouse) {
		BuyHouse = buyHouse;
	}
	public Housedata getSellHouse() {
		return SellHouse;
	}
	public void setSellHouse(Housedata sellHouse) {
		SellHouse = sellHouse;
	}
	public HAdata getSellHA() {
		return SellHA;
	}
	public void setSellHA(HAdata sellHA) {
		SellHA = sellHA;
	}
	public int getDist() {
		return Dist;
	}
	public void setDist(int dist) {
		Dist = dist;
	}
	public Score ( int scoreBuy, int scoreSell, Housedata buy1, Housedata sell1, HAdata setSellTargetHA, Simulator simulator, int dist ) { //�X�R�A�̐���
		setScoreforBuy ( scoreBuy );
		setScoreforSell ( scoreSell );
		setBuyHouse ( buy1 );
		setSellHouse ( sell1 );
		setSellHA ( setSellTargetHA );
		simulator.setScoreList ( this );
		setDist ( dist );
	}
}

@SuppressWarnings("rawtypes")
class BuyScoreComparator implements java.util.Comparator {
	public int compare ( Object s, Object t ) {
		return ( ( Score ) s ).getScoreforBuy() - ( ( Score ) t ).getScoreforBuy();
	}
}

@SuppressWarnings("rawtypes")
class SellScoreComparator implements java.util.Comparator {
	public int compare ( Object s, Object t ) {
		return ( ( Score ) s ).getScoreforSell() - ( ( Score ) t ).getScoreforSell();
	}
}
