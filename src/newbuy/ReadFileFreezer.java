package newbuy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFileFreezer {
	private List < freezer > NewfreezerList = new ArrayList <> (); //�①�ɂ̃��X�g
	public ReadFileFreezer	() {
		
	}
	
	public void setfreezerlist ( freezer freezer ) {
		NewfreezerList.add ( freezer );		
	}
	public List < freezer > getfreezerlist() {
		return NewfreezerList;
	}
	
	public void createNewFreezerList ( String Name ) { //�t�H���_���𓊂��ĐV�i�①�ɂ����
		try {
			//�t�@�C�����[�_�[
			 File file = new File ( Name );
			 BufferedReader br = new BufferedReader ( new FileReader ( file ) );
			//�����܂Ńt�@�C�����[�_�[
			 
			 String str = "0" ; //�ǂݎ��pString�֐� �������k���ɂ���Ǝ~�܂�i������O���j

			//�ǂݍ��݃��\�b�h
			while ( str != null ) { //EOF��null�Ƃ��Č��o�A����܂ł͓ǂݍ��ݑ�����
				str = br.readLine ();
				if (str != null) { //�ǂݍ��ݍs��null�łȂ���΂��̃V�[�P���X�����s�A�s���Ŕ��ʂ���
					if ( str.startsWith ( "#" ) ); //�R�����g�������o����Ɖ������Ȃ�
					else {
						String StAry[] = str.split ( ", ", 2 ); //�R�X�g�ƃX�y�b�N�œ�
						new freezer ( this, Integer.parseInt( StAry[1] ), Integer.parseInt( StAry[0] ) );
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
