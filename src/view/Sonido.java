package view;


import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sonido{

	javax.sound.sampled.Clip sonido;
	
	public Sonido(String audio){
		
		String dir = System.getProperty("user.dir");
        dir=getPath(dir + "\\src\\vista\\" + audio);
        
		try
		{
		  sonido=AudioSystem.getClip();
		  sonido.open(AudioSystem.getAudioInputStream(new File(dir)));
		}catch(Exception e)
		  {System.out.println("No se pudo cargar el audio");}
		
	}
	
	private String getPath(String p) {
	        String dir="";
	        char d=((char)92);
	        for(int x=0;x<p.length();x++)
	        {
	            char l=p.charAt(x);
	            if(d==l)
	            {
	                dir+="\\";
	            }
	            else
	            {
	                dir+=l+"";
	            }
	        }
	        return dir;
	}

	public void reproducirIndefinidamente() {
		sonido.loop(Clip.LOOP_CONTINUOUSLY); //Para que se reproduzca indefinidamente
	}

	public void detener() {
		sonido.stop();
	}

	public void reproducir() {
		sonido.start();
	}
	
	public boolean estaSonando(){
		return sonido.isRunning();
	}

	public void verificarQueEstaSonando(){
		
		if (this.estaSonando() == false){
			this.reproducirIndefinidamente();	
		}
	}
	
	
}