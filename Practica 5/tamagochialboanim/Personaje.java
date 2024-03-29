import java.awt.*;
import javax.swing.*;
import javax.vecmath.*;
import com.sun.j3d.utils.picking.*;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.image.*;
import javax.media.j3d.*;
import com.sun.j3d.utils.geometry.Text2D;
import com.sun.j3d.utils.behaviors.mouse.*;
import com.sun.j3d.loaders.*;
import com.glyphein.j3d.loaders.milkshape.MS3DLoader;
import com.sun.j3d.loaders.objectfile.ObjectFile;
import com.sun.j3d.loaders.*;
import com.sun.j3d.loaders.lw3d.*;
import ncsa.j3d.*;
import ncsa.j3d.loaders.*;

import java.text.DecimalFormat;
class Personaje {
        float x, y, z;
        private BranchGroup group;
        TransformGroup tran;
        private Transform3D t3d, toMove, toRot; 
	String nick;
        public final static float MOVERATE = 0.3f;
        private DecimalFormat df;
        int getX(){ return (int)x; }
   	int getY(){ return (int)y; }
	public Personaje(String name, float x, float  y, float z){
		this.x=x;
		this.y=y;
		this.nick=nick;
                group=new BranchGroup(); 
                tran= new TransformGroup();
                t3d = new Transform3D();
                toMove = new Transform3D();
        	tran.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
         	tran.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		tran.addChild(getMS3D(
                 "Models/"+name /*"Personaje2.ms3d"*/
		).getSceneGroup());
		//tran.addChild(getObj("horse.obj").getSceneGroup());
                //tran.addChild(loadFile(
                //"/home/rtecla/alice_agent/alice_cart1/Models/Rueda.wrl"
                //).getSceneGroup());
		group.addChild(tran);
		
	}
        public BranchGroup mybody(){
        	return group;
    	}
        public void turn(int ang){
    	float angulo=ang*((float)Math.PI/180.0f);
    		try{
      			if(angulo < Math.PI ){
          			angulo+=0.2f;
          		Transform3D t3d2=new Transform3D();
          		t3d2.rotY(-angulo);
	  		//t3d2.rotY(Math.PI   + nAnguloDoor);
          		tran.setTransform(t3d2);
      		}
    		}catch(Exception e){
    		}
  	}
	public void move(int i, int j, int k, int l){
   	}
	private void printTuple(Tuple3d t, String id){
    	System.out.println(id + " x: " + df.format(t.x) + 
				", " + id + " y: " + df.format(t.y) +
				", " + id + " z: " + df.format(t.z));
  	}  // end of printTuple()
   	public void moveForward(){ 
    		moveBy(0.0, MOVERATE); 
  	}

  	public void moveBackward(){ 
    		moveBy(0.0, -MOVERATE); 
  	}
  	public void moveLeft(){ 
    		moveBy(-MOVERATE,0.0); 
  	}
  	public void moveRight(){ 
    		moveBy(MOVERATE,0.0); 
  	}
	public void moveBy(double x, double z){
        	doMove( new Vector3d(x, 0, z) );  
  	}  // end of moveBy()
	private void doMove(Vector3d theMove){
    		tran.getTransform( t3d );
    		toMove.setTranslation(theMove);    // overwrite previous trans
    		t3d.mul(toMove);
    		tran.setTransform(t3d);
  	}  // end of doMove()
        public static Scene getMS3D(String name) {
		int flags = MS3DLoader.LOAD_ALL;
		Scene s = null;
		try {	
			Loader loader = new MS3DLoader (MS3DLoader.LOAD_ALL);
			java.io.File file = new java.io.File(name);
			if (file.getParent().length() > 0) {// figure out the base path
                                System.out.println(file.getName()+"11 padre "+file.getParent() + java.io.File.separator);
  				loader.setBasePath(file.getParent() + java.io.File.separator);
			}
                        System.out.println(file.getName()+"22 padre "+file.getParent() + java.io.File.separator);
			s = loader.load(file.getName());
		}
      		catch (java.io.FileNotFoundException ex){
			System.err.println("Error: "+ex);
      		}
		return s;
        }
	public static Scene getObj(String name) {
        int flags = ObjectFile.RESIZE | ObjectFile.LOAD_ALL;
        ObjectFile f = new ObjectFile(flags);
        Scene s = null;
        System.out.println("Loading...");
        try {
            s = f.load(name);
            System.out.println("Loaded!");
        }
        catch(Throwable t) { System.err.println("Error: "+t); }
        return s;
    }
    private static Scene loadFile(String fnm){
	Scene s = null;
    	ModelLoader modelLoader = new ModelLoader();
	try {
	  s = modelLoader.load(fnm);   // handles many types of file
	}
	catch (Exception e) {
	  System.err.println(e);
	  //System.exit(1);
	}
        return s;
    }
}
