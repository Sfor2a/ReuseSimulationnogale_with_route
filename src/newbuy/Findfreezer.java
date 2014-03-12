package newbuy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Findfreezer {
	List < freezer > FFL = new ArrayList <> (); //�i�荞�ݏI����̂����炵���①�Ƀ��X�g
	List < freezer > CFFL = new ArrayList <> (); //�R�X�g�ł��i�荞�ݏI����̐V�������X�g
	
	public void setFFL ( freezer freezer ) {
		FFL.add ( freezer );
	}
	public void setCFFL ( freezer freezer ) {
		CFFL.add ( freezer );
	}
	public List < freezer > getFFL () {
		return FFL;
	}
	public List < freezer > getCFFL () {
		return CFFL;
	}
	
	public Findfreezer () {
	}
	public int personselector () {
		Random rnd = new Random();
		int people = rnd.nextInt( 8 ) + 1;
		return people;
	}
	
	public int personcountspec ( int P ) { //���l�Ƒ����������Ƃ���ɕK�v�Ȕ͈͂̃X�y�b�N�������Ă����
		int spec = 0;
		if ( P == 1 ) spec = 140;
		else spec = ( 70 * P ) + 170;
		return spec; 
	}
	
	public void findfreezerspec ( int spec, ReadFileFreezer RF ) { //�X�y�b�N�ŗ①�ɍi�荞��
		List < freezer > FL = RF.getfreezerlist(); //�①�Ƀ��X�g�����������Ă���
		int minspec = ( int ) ( spec * 0.91 ); //�����͈͂̉�������������Ă�
		int maxspec = ( int ) ( spec * 1.09 ); //���͈̔͂̃X�y�b�N�ŗ①�ɂ�T��
		for ( int i = 0; i < FL.size(); i++ ) {
			int targetspec = FL.get(i).getSpec();
			if ( targetspec > minspec && targetspec < maxspec ) {
				setFFL ( FL.get(i) ); //�i�荞�񂾉Ƌ�����X�g�ɒǉ�
				//System.out.println("�X�y�b�N���"+maxspec+"�X�y�b�N����"+minspec+"�I�񂾃X�y�b�N"+FL.get(i).getSpec());
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public void findfreezercost ( int cost ) {
		List < freezer > CFL = getFFL();
		Collections.sort(CFL, new FreezerComparator());
		for( int i = 0; i < CFL.size(); i++ ) {
			if ( CFL.get(i).getCost() > ( int ) ( cost * 0.9 ) && CFL.get(i).getCost() < ( int ) ( cost * 1.1 ) ){
				setCFFL ( CFL.get(i) );
				//System.out.println( "�R�X�g���"+ ( cost * 1.1 ) +"�R�X�g����"+ ( cost * 0.9 ) +"�I�񂾃R�X�g"+CFL.get(i).getCost() );
			}
		}
	}
	
	public freezer FindFreezerLast () { //freezer��I��ŕԂ�
		freezer CFL = null;
		List < freezer > LFL = getCFFL();
		Random rnd = new Random();
		int i = rnd.nextInt( LFL.size() );
		CFL = LFL.get(i);		
		return CFL;
	}
}

@SuppressWarnings("rawtypes")
class FreezerComparator implements java.util.Comparator {
	public int compare ( Object s, Object t ) {
		return ( ( freezer ) s ).getCost() - ( ( freezer ) t ).getCost();
	}
}

