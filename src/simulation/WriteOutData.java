package simulation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class WriteOutData {
	
	File file = new File ( ".\\recycle\\WriteOut\\WritedOut_data10.csv" ); //�������ރt�@�C����
	List < Integer > StoreScore = new ArrayList <> (); 
	List < Integer > RankBuyStore = new ArrayList <> (); 
	List < Integer > RankSellStore = new ArrayList <> (); 
	
	public WriteOutData ( int SellNum, int BuyNum ) { //����������]�l��
		PrintWriter pw;
		try {
			pw = new PrintWriter (new BufferedWriter ( new FileWriter ( file, true ) ) );
			pw.println ( ",���肽���Ƃ̐�," + SellNum+ ",���������Ƃ̐�," + BuyNum + "," );
			pw.close();
		} catch ( IOException e ) {
			System.err.println ( "File cannot be Writed." );
		} //println�̗p��
	}
	public void WriteOut ( Score ReuseTarget, int KK, int JJ ) {
		PrintWriter pw;
		try {
			pw = new PrintWriter (new BufferedWriter ( new FileWriter ( file, true ) ) );
			pw.println ( "," + ReuseTarget.getBuyHouse().getName() + "," +ReuseTarget.getSellHouse().getName() + "," + ReuseTarget.getDist() + "," +
					ReuseTarget.getScoreforSell() + "," + KK + "," + JJ );
			Storage ( ReuseTarget.getDist(), KK, JJ );
			pw.close();
		} catch ( IOException e ) {
			System.err.println ( "File cannot be Writed." );
		} //println�̗p��
	}
	
	private void Storage(int dist, int kK, int jJ) {
		StoreScore.add ( dist );
		RankBuyStore.add (kK);
		RankSellStore.add (jJ);
	}
	public void Adjust( int SellNum, int BuyNum ) { //���������Q���l��
		PrintWriter pw;
		try {
			pw = new PrintWriter (new BufferedWriter ( new FileWriter ( file, true ) ) );
			pw.println ( ",���ꂽ�Ƃ̐�," + SellNum+ ",�������Ƃ̐�," + BuyNum + "," );
			pw.println ( ",������肷���,�����,�����܂ł̋���,�������i,���ԖڂɍD���Ȑl���甃����,���ԖڂɍD���Ȑl�ɔ��ꂽ" );
			pw.close();
		} catch ( IOException e ) {
			System.err.println ( "File cannot be Writed." );
		} //println�̗p��
	}
	public void None() { //����Ȃ��̏����o��
		PrintWriter pw;
		try {
			pw = new PrintWriter (new BufferedWriter ( new FileWriter ( file, true ) ) );
			pw.println ( ",����Ȃ�" );
			pw.close();
		} catch ( IOException e ) {
			System.err.println ( "File cannot be Writed." );
		} //println�̗p
	}
	
	public void WriteDist () {
		PrintWriter pw;
		try {
			pw = new PrintWriter (new BufferedWriter ( new FileWriter ( file, true ) ) );
			pw.print ( ",������ɂ����鋗���̕���" );
			int KK = 0;
			for ( int i = 0; i < StoreScore.size(); i++ ) {
				KK += StoreScore.get( i );
			}
			
			if ( StoreScore.size() != 0  ) {
				pw.print ( "," + ( double ) ( KK / StoreScore.size() ) + ",���Z�n," + KK  );
			}
			KK = 0;
				for ( int i = 0; i < RankSellStore.size(); i++ ) {
					KK += RankSellStore.get( i );
				}
			if ( RankSellStore.size() != 0 ) {
				pw.print ( ",���ԖڂɍD���Ȑl�ɔ��ꂽ�̕���," + ( double ) ( KK / RankSellStore.size() ) );
			}
			KK = 0;
				for ( int i = 0; i < RankBuyStore.size(); i++ ) {
					KK += RankBuyStore.get( i );
				}
			if ( RankBuyStore.size() != 0 ) {
				pw.print ( ",���ԖڂɍD���Ȑl���甃�����̕���," + ( double ) ( KK / RankBuyStore.size() ) );
			}
			
			pw.println();
			pw.close();
		} catch ( IOException e ) {
			System.err.println ( "File cannot be Writed." );
		} //println�̗p
	}
}

