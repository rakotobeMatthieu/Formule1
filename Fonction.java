package fonction;

import connexion.*;
import tracable.*;
import java.util.*;
import java.sql.*;

public class Fonction{
    public Vector<F1> getAllF1(){
		Vector<F1> rep = new Vector<F1>();
		try{
			Connexion c=new Connexion();
			String sql = "SELECT id,num,couleur,x,y,vitesse,tour,tourRestant FROM F1";
			ResultSet rs=c.getStatement().executeQuery(sql);
			while(rs.next()){
				F1 f = new F1(5,rs.getInt(4),rs.getInt(5),rs.getString(3),rs.getInt(6),rs.getString(1),rs.getInt(7),rs.getInt(8),rs.getString(2));
				rep.add(f);
			}
			rs.close();
			c.getConnection().close(); 
		}
		catch(Exception e){ 
        	e.printStackTrace();
    	}
		// System.out.println(rep);
		return rep;
	}

    public int getTailleF1(){
		int rep = 0;
		try{
			Connexion c=new Connexion();
			String sql = "SELECT COUNT(*) nb FROM F1";
			ResultSet rs=c.getStatement().executeQuery(sql);
			while(rs.next()){
				rep = rs.getInt(1);
			}
			rs.close();
			c.getConnection().close(); 
		}
		catch(Exception e){ 
        	e.printStackTrace();
    	}
		// System.out.println(rep);
		return rep;
	}
}