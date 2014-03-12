package housedata;

public class HAdata extends HouseElements {
	private int Durability; //���̉Ƌ�̑ϋv�x
	private int MinusDur; //1�^�[���ɂ����錸���ϋv�x�i�܂��͎g��Ȃ����@�ŁH�H�H
	private int MaxValue; //�V�i�ł̉��i
	private String Spec; //�X�y�b�N�@�①�ɂȂ烊�b�g���A�d�q�����W�Ȃ����Ɛ��Ȃ�
	private int TermValue; //�ϋv�x������̉��i�i�����x�����Ȃ炱��������
	private int Exchangecount; //�����񐔁i����
	private static int HPAIDadd; //ID���Z
	private int UseTernCount;
	
	//�Q�b�^�[�Z�b�^�[
	public int getDurability() {
		return Durability;
	}
	public void setDurability(int durability) {
		Durability = durability;
	}
	public int getMinusDur() {
		return MinusDur;
	}
	public void setMinusDur(int minusDur) {
		MinusDur = minusDur;
	}
	public int getMaxValue() {
		return MaxValue;
	}
	public void setMaxValue(int maxValue) {
		MaxValue = maxValue;
	}
	public int getTermValue() {
		return TermValue;
	}
	public void setTermValue(int termValue) {
		TermValue = termValue;
	}
	public int getExchangecount() {
		return Exchangecount;
	}
	public void setExchangecount(int exchangecount) {
		Exchangecount = exchangecount;
	}
	public String getSpec() {
		return Spec;
	}
	public void setSpec(String spec) {
		Spec = spec;
	}
	public int getUseTernCount() {
		return UseTernCount; 
	}
	public void setUseTernCount ( int Utc ) {
		UseTernCount = Utc; 
	}
	//�����܂ŃQ�b�^�[�Z�b�^�[
	

	public HAdata(String Nam, String spec, int Val, int MD, Housedata HH) { //�Ƌ�������
		ID = HPAIDadd++;
		setExchangecount ( 0 );
		setName ( Nam );
		setDurability ( 100 );
		setTermValue ( Val );
		setMaxValue ( Val );
		setMinusDur ( MD );
		setSpec(spec);
		setUseTernCount ( 0 );
		HH.setHAdata ( this );
	}
	
	public boolean equals(Object obj){
	    HAdata t = ( HAdata )obj;
	    String ts = t.Name;

		if( Name.equals ( ts ) ) return true;
		else return false;
	}
}
