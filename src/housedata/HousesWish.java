package housedata;

import java.util.ArrayList;
import java.util.List;

public class HousesWish extends HouseElements {
	private static int WLNum = 0;
	private List < HAsWishValue > HAsWishValList = new ArrayList <> (); //�ϋv�x�Ɖ��i�̃��X�g
	
	//�Q�b�^�[
	public List< HAsWishValue > getHAsWishValList () {
		return HAsWishValList;
	}
	//�Z�b�^�[
	public void setHAsWishVal ( HAsWishValue WVL ) {
		HAsWishValList.add ( WVL );
	}
	
	public HousesWish ( String nam, int Dur, int cost, Housedata HD, String spec ) { //�E�B�b�V�����X�g�������
		ID = WLNum++;
		setName ( nam ); //�E�B�b�V�����X�g�ɂ����̖��O���Ȃ���ΐV���������̖��O�����
		new HAsWishValue ( this, Dur, cost, spec );//n%�ȏ�̉��l�ŉ��~�Ɣ��f
		HD.setHousesWish ( this );
	}	
}