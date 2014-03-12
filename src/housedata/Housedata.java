package housedata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import simulation.Simulator;

public class Housedata extends HouseElements { //�Ƃ̃f�[�^���Ǘ�����
	public List < HAdata > FurnitureList = new ArrayList <> (); //�Ƌ�X�g
	public List < HousesWish > HousesWishList = new ArrayList <> (); //�ق������̃��X�g
	private int Coin; //�R�C��
	private static int HouseIDAdd; //ID���Z
	
	//�Q�b�^�[�E�Z�b�^�[
	public List<HAdata> getHAList() {
		return FurnitureList;
	}
	public List<HousesWish> getHousesWishList() {
		return HousesWishList;
	}
	public void setHousesWish ( HousesWish WL ) {
		HousesWishList.add ( WL );
	}
	public int getCoin() {
		return Coin;
	}
	public void setCoin(int coin) {
		Coin = coin;
	}
	public void setHAdata ( HAdata HPA ) {
		FurnitureList.add ( HPA );
	}

	//�Q�b�^�[�E�Z�b�^�[�I��
	
	public Housedata ( String Nam, int Val, Simulator simulator ) {
		ID = HouseIDAdd++; //ID���Z���邾��
		setName ( Nam ); //�Ƃ̖��O�Z�b�g
		setCoin ( Val ); //����������Ă邩�ȁ[
		reedingHPAName ( Nam ); //�Ƌ���ɍs���܂�
		reedingWishlistName ( Nam ); //��]���i���X�g�ǂݍ���
		simulator.setHouseList ( this ); //�������̃��X�g�ɂ�����
	}
	private void reedingHPAName ( String str1 ) { //�Ƌ����
		try {
			String Housename= ".\\recycle\\furnituredata\\" + str1 + "_furniture.txt"; 
			//�t�@�C�����[�_�[
			 File file = new File ( Housename );
			 BufferedReader br = new BufferedReader ( new FileReader ( file ) );
			//�����܂Ńt�@�C�����[�_�[
			 
			 String str = "0" ; //�ǂݎ��pString�֐� �������k���ɂ���Ǝ~�܂�i������O���j
			 String[] FurnitureAry = new String[4];
			
			//�ǂݍ��݃��\�b�h
			do { //EOF��null�Ƃ��Č��o�A����܂ł͓ǂݍ��ݑ�����
				str = br.readLine (); //��s��ǂݍ��� �ǂݍ��ނ��тɎ���if���V�[�P���X�Ŕ���
				if (str != null) { //�ǂݍ��ݍs��null�łȂ���΂��̃V�[�P���X�����s�A�s���Ŕ��ʂ���
					if ( str.startsWith ( "Name " ) ) {
						String[] strAry = str.split( " ", 2 );
						FurnitureAry[0] = strAry[1];
					}
					else if ( str.startsWith ( "Value " ) ) {
						String[] strAry = str.split( " ", 2 );
						FurnitureAry[1] = strAry[1];
						//System.out.print(strAry[1]+",");
					}
					else if ( str.startsWith ( "Minus " ) ) {
						String[] strAry = str.split( " ", 2 );
						FurnitureAry[2] = strAry[1];
					}
					else if ( str.startsWith ( "Spec " ) ) {
						String[] strAry = str.split( " ", 2 );
						FurnitureAry[3] = strAry[1];
						//System.out.println(strAry[1]);
					}
					else if ( str1.startsWith ( "//" ) ); //�R�����g�������o����Ɖ������Ȃ�
					else System.out.println( "err." );
					
					if ( FurnitureAry[0] != null && FurnitureAry[1] != null && FurnitureAry[2] != null ) { //�ǂ����������ꂽ�Ƃ��Ɏ��s
						new HAdata ( FurnitureAry[0], FurnitureAry[3], Integer.parseInt ( FurnitureAry[1] ), Integer.parseInt ( FurnitureAry[2] ), this ); //�Ƌ����Ă���
						FurnitureAry [0] = null;
						FurnitureAry [1] = null; //�����ĂƂ��ǂ����Z�b�g
						FurnitureAry [2] = null;
						FurnitureAry [3] = null; //�����ĂƂ��ǂ����Z�b�g
						}
				}
			} while ( str != null );
			//�����܂œǂݍ��݃��\�b�h
			br.close(); //�t�@�C�������	
		} catch ( FileNotFoundException e ) { //��O����
			System.err.println ( e.getMessage () ); //�t�@�C���Ȃ��̗�O	
			System.exit ( 0 );
		} catch ( IOException e ) {
		    System.err.println ( e.getMessage () ); //IO�G���[��O
		    System.exit ( 0 );
		}
	}
	
	private void reedingWishlistName ( String str1 ) {
		try {
			String Housename= ".\\recycle\\wishlist\\" + str1 + "_wishlist.txt"; 
			//�t�@�C�����[�_�[
			 File file = new File ( Housename );
			 BufferedReader br = new BufferedReader ( new FileReader ( file ) );
			//�����܂Ńt�@�C�����[�_�[
			 
			 String str = "0" ; //�ǂݎ��pString�֐� �������k���ɂ���Ǝ~�܂�i������O���j
			 String[] FurnitureAry = new String[4];
			 int JJ = 0; //�X�C�b�`�p�ϐ�
			
			//�ǂݍ��݃��\�b�h
			while ( str != null ) { //EOF��null�Ƃ��Č��o�A����܂ł͓ǂݍ��ݑ�����
				str = br.readLine (); //��s��ǂݍ��� �ǂݍ��ނ��тɎ���if���V�[�P���X�Ŕ���
				if (str != null) { //�ǂݍ��ݍs��null�łȂ���΂��̃V�[�P���X�����s�A�s���Ŕ��ʂ���
					if ( str.startsWith ( "Name " ) ) {
						String[] strAry = str.split( " ", 2 );
						FurnitureAry[0] = strAry[1];						
					}
					else if ( str.startsWith ( "Durability " ) ) {
						String[] strAry = str.split( " ", 2 );
						FurnitureAry[1] = strAry[1];			
					}
					else if ( str.startsWith ( "Value " ) ) {
						String[] strAry = str.split( " ", 2 );
						FurnitureAry[2] = strAry[1];			
					}
					else if ( str.startsWith ( "Spec " ) ) {
						String[] strAry = str.split( " ", 2 );
						FurnitureAry[3] = strAry[1];			
					}
					else if ( str1.startsWith ( "//" ) ); //�R�����g�������o����Ɖ������Ȃ�
					
					if ( FurnitureAry[0] != null && FurnitureAry[1] != null && FurnitureAry[2] != null && FurnitureAry[3] != null ) { //�ǂ����������ꂽ�Ƃ��Ɏ��s
						if ( JJ == 0 ) { //�����I��1���WishList�ɂԂ�����
							new HousesWish ( FurnitureAry[0], Integer.parseInt ( FurnitureAry[1] ), Integer.parseInt ( FurnitureAry[2] ), this, FurnitureAry[3] ); //�E�B�b�V�����X�g����Ă���
							JJ = 1;
							FurnitureAry [0] = null;
							FurnitureAry [1] = null;
							FurnitureAry [2] = null;
							FurnitureAry [3] = null;//�����ĂƂ��ǂ����Z�b�g
						}
						
						if ( FurnitureAry[0] != null && FurnitureAry[1] != null && FurnitureAry[2] != null && FurnitureAry[3] != null ) { //��x�ʂ��ꂽ���̂͏��if���Ń��Z�b�g����邩��ʂ�Ȃ�
							for ( int i = 0; i < HousesWishList.size (); i++ ) { //WishList��������
								if ( !HousesWishList.get ( i ).getName ().equals ( FurnitureAry[0] ) ) { //WishList�̒��ɖ��O�̂����Ƌ�Ȃ��Ƃ��Ɍ���A�V�����N���X�Ƃ��ă��[�h
									new HousesWish ( FurnitureAry[0], Integer.parseInt ( FurnitureAry[1] ), Integer.parseInt ( FurnitureAry[2] ), this, FurnitureAry[3] ); //�E�B�b�V�����X�g����Ă���
								}
								else if ( HousesWishList.get ( i ).getName ().equals ( FurnitureAry[0] ) ) { //�������O�����̂��������Ƃ�
									HousesWishList.get ( i ).getHAsWishValList ().add ( 
											new HAsWishValue ( HousesWishList.get ( i ), Integer.parseInt ( FurnitureAry[1] ), Integer.parseInt ( FurnitureAry[2] ), FurnitureAry[3] ) );
									HousesWishList.get( i ).getHAsWishValList ().remove ( HousesWishList.get( 0 ).getHAsWishValList ().size() - 1 ); //��x�Z�b�g����邩��1�����i
								}
							}
						}						
						FurnitureAry [0] = null;
						FurnitureAry [1] = null;
						FurnitureAry [2] = null;
						FurnitureAry [3] = null;//�����ĂƂ��ǂ����Z�b�g
						}
				}			
			}
			//�����܂œǂݍ��݃��\�b�h
			br.close(); //�t�@�C�������	
		} catch ( FileNotFoundException e ) { //��O����
			System.err.println ( e.getMessage () ); //�t�@�C���Ȃ��̗�O	
			System.exit ( 0 );
		} catch ( IOException e ) {
		    System.err.println ( e.getMessage () ); //IO�G���[��O
		    System.exit ( 0 );
		}
	}	
}
