package mapdata;

import java.util.ArrayList;
import java.util.List;

import simulation.Simulator;

public class Point extends Map_Elements {
	private List < Routedata > RoutedataIn = new ArrayList <> (); //�͂����Ă��铹�̃��X�g
	private List < Routedata > RoutedataOut = new ArrayList <> (); //�łĂ������̃��X�g
	private static int PointNum = 0; //���Z�p�ϐ�
	private int X; //�n�_��x���W
	private int Y; //�n�_��Y���W
	private int Classification; //���
	
	//�Z�b�^�[��
	public void setRoutedataIn ( Routedata  PthIn ) { //RoutedataIn�̃Z�b�^�[
		RoutedataIn.add ( PthIn );
	}
	public void setRoutedataOut ( Routedata  PthOut ) { //RoutedataOut�̃Z�b�^�[
		RoutedataOut.add ( PthOut );
	}
	public void setX ( int seX ) {
		X = seX;
	}
	public void setY ( int seY ) {
		Y = seY;
	}
	public void setClassification ( int seC ) {
		Classification = seC;
	}
	//�����܂ŃZ�b�^�[��
	
	//�Q�b�^�[��
	public Routedata getRoutedataIn ( int Num ) { //�w�肵���ԍ���RoutedataIn�����X�g����擾
		Routedata Pthi = RoutedataIn.get ( Num ); 
		return Pthi;
	}
	public Routedata getRoutedataOut ( int Num ) { //�w�肵���ԍ���RoutedataOut�����X�g����擾
		Routedata Ptho = RoutedataOut.get ( Num ); 
		return Ptho;
	}
	public List < Routedata > getRteInList () { //RoutedataInList���̂��̂������Ă���Q�b�^�[
		List < Routedata > PthInList = RoutedataIn; 
		return PthInList;	
	}
	public List < Routedata > getRteOutList () { //RoutedataOutList���̂��̂������Ă���Q�b�^�[
		List < Routedata > PthOutList = RoutedataOut; 
		return PthOutList;	
	}
	public int getX () { //X���W���擾
		int geX = X;
		return geX;
	}	
	public int getY () { //Y���W���擾
		int geY = Y;
		return geY;
	}
	public int getClassification () {
		int geC = Classification;
		return geC;
	}
	//�����܂ŃQ�b�^�[����
		
	public Point( Simulator simulator, String PointName, int sX, int sY, int sC) {
			ID = PointNum++; //�|�C���g���ł��邽�тɉ��Z
			setName ( PointName ); //�����̖��O��K�p
			setX ( sX ); //X���W��ݒ�
			setY ( sY ); //Y���W��ݒ�
			setClassification ( sC ); //��ʂ��`�@1.�� 2.�����_
			simulator.setPoint ( this ); //���W���`
	}
}

