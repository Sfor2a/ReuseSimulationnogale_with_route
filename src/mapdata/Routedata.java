package mapdata;

import simulation.Simulator;


public class Routedata extends Map_Elements {
	private Point From; //�ǂ����炫����
	private Point To; //�ǂ��ւ�����
	private int MoveCosts; //�ړ��R�X�g
	private static int RouteNum = 0; //���Z�p�ϐ�
	
	//�Z�b�^�[��
	public void setFrom ( Point from ) { //From�̃Z�b�^�[
		From = from;
	}
	public void setTo ( Point to ) { //To�̃Z�b�^�[
		To = to;
	}
	public void setMoveCosts ( int moveCosts ) { //�R�X�g�̃Z�b�^�[
		MoveCosts = moveCosts;
	}
	//�����܂ŃZ�b�^�[��
	
	//�Q�b�^�[��
	public Point getTo () { //To�̃Q�b�^�[
		return To;
	}
	public Point getFrom () { //From�̃Q�b�^�[
		return From;
	}
	public int getMoveCosts () { //�R�X�g�̃Q�b�^�[
		return MoveCosts;
	}
	//�����܂ŃQ�b�^�[��
	public Routedata ( Simulator simulator, Point FromPoint, Point ToPoint, int Costs ) { //���������
		ID = RouteNum++; //Route66�@�݂�����
		setName ( FromPoint.getName () + ", " + ToPoint.getName () ); //���l���{�ꓹ�H�I�Ȗ��O
		setFrom ( FromPoint ); //�ǂ����炩
		setTo ( ToPoint ); //�ǂ��ւ�����
		setMoveCosts ( Costs ); //�R�X�g���Z�b�g
		simulator.setRoute ( this ); //���H���`
	}
}
