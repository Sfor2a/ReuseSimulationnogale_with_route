package housedata;

public class HAsWishValue extends HouseElements {
	private int Durability; //�ϋv�x
	private int Cost; //����Ɍ��������l
	private String spec;
	private static int WVLNum; //ID���Z
	
	//�Q�b�^�[�E�Z�b�^�[
	public int getDurability() {
		return Durability;
	}
	public void setDurability(int durability) {
		Durability = durability;
	}
	public int getCost() {
		return Cost;
	}
	public void setCost(int cost) {
		Cost = cost;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	
	public HAsWishValue ( HousesWish WL, int Dur, int cost, String spec ) { //���̉Ƌ�̃E�B�b�V�����X�g����
		ID = WVLNum++;
		setDurability ( Dur );
		setCost ( cost );
		setSpec ( spec );
		WL.setHAsWishVal ( this );
	}

}
