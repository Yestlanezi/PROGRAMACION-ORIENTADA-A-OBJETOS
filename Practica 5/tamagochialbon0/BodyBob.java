import com.sun.j3d.utils.picking.*;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.image.*;
import javax.media.j3d.*;
import com.sun.j3d.utils.geometry.Text2D;
import com.sun.j3d.utils.behaviors.mouse.*;
import javax.vecmath.*;
import java.awt.*;
import javax.swing.*;

public class BodyBob implements Movible {
    private BranchGroup group;
    private static Texture texture;
    private Appearance appearance;
    private TextureLoader loader;
    TransformGroup rotacion= new TransformGroup();
    TransformGroup tran;
    Text2D textObject;
    Appearance ap;
    JFrame frame1;
    Sphere cab;
    float x, y, z;
    private TransformGroup tg2Tron;
    private TransformGroup tg2HD;
    private TransformGroup tg2HI;
    TransformGroup tg11HD;
    private double nAnguloDoor=Math.PI*2;
    int orientacion;
    private Transform3D t3d, toMove, toRot;   

    Transform3D t3dbala;
    private TransformGroup viewerTG;
    public final static float MOVERATE = 0.05f;
    private Point3d bobPosn;
    //LaserBeam lb;
    //RayoLaser rl;
    TransformGroup tgbala;
    BranchGroup bgBala;
    BranchGroup bgBala1;
    public void disparo(){
       //lb.shootBeam(new Point3d(0, 3,0));
    }
   public void disparo1(){ 
	//bgBala.detach(); 
      //tran.setCapability(TransformGroup.ALLOW_AUTO_COMPUTE_BOUNDS_READ);
        // tran.setCapability(TransformGroup.ALLOW_AUTO_COMPUTE_BOUNDS_WRITE);
         //transformacion1.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
         //transformacion1.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        /*mar 2017 Vector3f posbala =new Vector3f(0.0f,-0.075f,0f);
        rl=new RayoLaser(new Vector3d(0,0, 1), null);
        t3dbala.set(1, new Vector3f(0, 0, 0));
        rl.setTransform3D(t3dbala);
        
        bgBala1=translate1(rl.getBeamBG(), posbala);
        tran.addChild(bgBala1);
        rl.shootBeam(new Point3d(0, 0, 8));*/
        //rl.shootBeam(getCurrLoc());
	//lb.shootBeam(new Point3d(0, 8, 0));
        //lb=new LaserBeam(new Vector3d(0,0,0), null);
	
	//bgBala.addChild(lb.getBeamBG());
        //tg11HD.addChild(bgBala);
  }
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
  public Point3d getCurrLoc(){        
    tran.getTransform( t3d );
    Vector3d trans = new Vector3d();
    t3d.get( trans );
    //printTuple(trans, "currLoc");
    System.out.println("Body CUR loc x= ("+trans.x+
        ") y = ("+trans.y+ 
        ") z = ("+trans.z+")");
    return new Point3d( trans.x, trans.y, trans.z);
  }  
   public void moveBy(double x, double z)
  /* Move the sprite by offsets x and z, but only if within the floor
     and there is no obstacle nearby. */
  {
        doMove( new Vector3d(x, 0, z) );  
        //viewerMove(); 
  }  // end of moveBy()
  public void doMove1(Vector3d theMove)
  // Move the sprite by the amount in theMove
  {
    tran.getTransform( t3d );
    t3d.setTranslation(theMove);    // overwrite previous trans
    //t3d.mul(toMove);
    //tran.setTransform(t3d);
  }  
    private void doMove(Vector3d theMove)
  // Move the sprite by the amount in theMove
  {
    tran.getTransform( t3d );
    toMove.setTranslation(theMove);    // overwrite previous trans
    t3d.mul(toMove);
    tran.setTransform(t3d);
  }  // end of doMove()
    
  private void viewerMove()
  // Updates the view point by the translation change of the sprite
  {
    Point3d newLoc = getCurrLoc();
    // printTuple(newLoc, "newLoc");
    Vector3d trans = new Vector3d( newLoc.x - bobPosn.x,
								0, newLoc.z - bobPosn.z);
    viewerTG.getTransform( t3d );
    toMove.setTranslation(trans);  // overwrites previous translation
    t3d.mul(toMove);
    viewerTG.setTransform(t3d);

    bobPosn = newLoc;   // save for next time
  }  


    public void giraTron(float angulo){
    try{
      if(angulo < Math.PI * 2){
          angulo+=0.2f;
          Transform3D t3d2=new Transform3D();
          t3d2.rotY(-angulo);
	  //t3d2.rotY(Math.PI   + nAnguloDoor);
          tg2Tron.setTransform(t3d2);
      }
    }catch(Exception e){
    }
  }
     public void giraHD(float angulo){
    try{
      if(angulo < Math.PI ){
          angulo+=0.2f;
          Transform3D t3d2=new Transform3D();
          t3d2.rotX(-angulo);
	  //t3d2.rotY(Math.PI   + nAnguloDoor);
          tg2HD.setTransform(t3d2);
      }
    }catch(Exception e){
    }
  }
    public void rotaHD(){
    try{
      while(nAnguloDoor > 3* (Math.PI/2) ){
          Thread.sleep(100);
          nAnguloDoor-=0.2f;
          Transform3D t3d2=new Transform3D();
          t3d2.rotX(nAnguloDoor);
	  //t3d2.rotY(Math.PI   + nAnguloDoor);
          tg2HD.setTransform(t3d2);
      }
    }catch(Exception e){
    }
  }
  public void giraHI(float angulo){
    try{
      if(angulo < Math.PI ){
          angulo+=0.2f;
          Transform3D t3d2=new Transform3D();
          t3d2.rotX(-angulo);
	  //t3d2.rotY(Math.PI   + nAnguloDoor);
          tg2HI.setTransform(t3d2);
      }
    }catch(Exception e){
    }
  }
    public void rotaHI(){
    try{
      while(nAnguloDoor > 3* (Math.PI/2) ){
          Thread.sleep(100);
          nAnguloDoor-=0.2f;
          Transform3D t3d2=new Transform3D();
          t3d2.rotX(nAnguloDoor);
	  //t3d2.rotY(Math.PI   + nAnguloDoor);
          tg2HI.setTransform(t3d2);
      }
    }catch(Exception e){
    }
  }
    public Sphere getCab(){
	return cab;
    }
    public TransformGroup getHD(){
       return tg2HD;
    }
    public TransformGroup getHI(){
       return tg2HI;
    }
    public BodyBob(float x, float y, float z,String nombre_mostrar,boolean movimiento, JFrame frame,String img/*, TransformGroup vTG*/){
	 this.x=x; this.y=y;this.z=z;
         group=new BranchGroup();

         t3d = new Transform3D();
         toMove = new Transform3D();
         //viewerTG = vTG;
         bobPosn=new Point3d(x,y,z);
         Appearance apa2 = new Appearance();
         TextureLoader loader2=new TextureLoader("fondo.jpg",frame);
         Texture texture2=loader2.getTexture();
         apa2.setTexture(texture2);
         Background backg = new Background(1.0f, 1.0f, 1.0f);
         backg.setImage(loader2.getImage());
         group.addChild(backg);
         frame1=frame;
         Transform3D cabeza=new Transform3D();
         Transform3D cuello=new Transform3D();
         Transform3D tronco=new Transform3D();
         Transform3D homizq=new Transform3D();
         Transform3D homder=new Transform3D();
         Transform3D braizq=new Transform3D();
         
         //brader.rotY(Math.PI/2);
         Transform3D pieizq=new Transform3D();
         Transform3D pieder=new Transform3D();
         Vector3f poscabeza =new Vector3f(x,y+0.25f,z);
         Vector3f poscuello =new Vector3f(x,y+0.15f,z);
        
        
         //Vector3f poshder =new Vector3f(x+0.085f,y+0.115f,z);
         
         //Material
         Material yellowSphMaterial = new Material();
         yellowSphMaterial.setDiffuseColor(0.85f, 0.85f, 0.85f);
         Appearance yellowSphAppearance = new Appearance();
         yellowSphAppearance.setMaterial(yellowSphMaterial);
         Appearance apa = new Appearance();
         loader=new TextureLoader(img,frame1);
         texture=loader.getTexture();
         apa.setTexture(texture);
         apa.setMaterial(yellowSphMaterial);
         Appearance apa1 = new Appearance();
         TextureLoader loader1=new TextureLoader("traje2Bob.jpg",frame1);
         Texture texture1=loader1.getTexture();
         apa1.setTexture(texture1);
         apa.setMaterial(yellowSphMaterial);
         //Cabeza
         
	tran= new TransformGroup();
        tran.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
         tran.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
         BoundingSphere bounds = new BoundingSphere(new Point3d(),0.0);
         cabeza.setTranslation(poscabeza);
         TransformGroup transformacion1= new TransformGroup(cabeza);
         
         if(movimiento){
         tran.setCapability(TransformGroup.ALLOW_AUTO_COMPUTE_BOUNDS_READ);
         tran.setCapability(TransformGroup.ALLOW_AUTO_COMPUTE_BOUNDS_WRITE);
         transformacion1.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
         transformacion1.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
         
         MouseRotate rotator=new MouseRotate(transformacion1);
         rotator.setSchedulingBounds(bounds);
         MouseTranslate t=new MouseTranslate(transformacion1);
         t.setSchedulingBounds(bounds);
         tran.addChild(t);
         tran.addChild(rotator);
         }
         int primflags = Primitive.GENERATE_NORMALS
        + Primitive.GENERATE_TEXTURE_COORDS;
         //cab=new Sphere(0.1f,primflags, 32,apa);
         com.sun.j3d.utils.geometry.Box cab = new com.sun.j3d.utils.geometry.Box(0.110f,.130f,.11f, Primitive.GENERATE_NORMALS | Primitive.GENERATE_TEXTURE_COORDS, apa);
         cab.setCapability(Primitive.ENABLE_APPEARANCE_MODIFY);
         ap = cab.getAppearance();
         ap.setCapability(Appearance.ALLOW_TEXTURE_ATTRIBUTES_WRITE);
         ap.setCapability(Appearance.ALLOW_TEXTURE_WRITE);
         ap.setCapability(Appearance.ALLOW_MATERIAL_WRITE);
         transformacion1.addChild(cab);
         tran.addChild(transformacion1);
         
         //Cuello
         cuello.setTranslation(poscuello);
         TransformGroup transformacion2= new TransformGroup(cuello);
         Cylinder cue=new Cylinder(0.025f,0.05f ,yellowSphAppearance);
         transformacion2.addChild(cue);
         tran.addChild(transformacion2);

         //Tronco       
    Vector3f postronco =new Vector3f(x,y,z);
    Transform3D t3d3Tron=new Transform3D();
    t3d3Tron.set(1, postronco);
    TransformGroup tg3Tron=new TransformGroup(t3d3Tron);
    Transform3D t3d2Tron=new Transform3D();
    t3d2Tron.rotX(nAnguloDoor);
    tg2Tron=new TransformGroup(t3d2Tron);
    tg2Tron.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
    Transform3D t3d1Tron=new Transform3D();
    t3d1Tron.set(1,new Vector3d(0.0f,0,0));
    TransformGroup tg1Tron=new TransformGroup(t3d1Tron);
    //Cylinder tron=new Cylinder(0.075f,0.25f,primflags ,apa1);
    com.sun.j3d.utils.geometry.Box tron = new com.sun.j3d.utils.geometry.Box(0.110f,.10f,.11f, Primitive.GENERATE_NORMALS | Primitive.GENERATE_TEXTURE_COORDS, apa1);
    tg1Tron.addChild(tron);
    tran.addChild(tg3Tron);
    tg3Tron.addChild(tg2Tron);
    tg2Tron.addChild(tg1Tron);

         //Hombro Derecho

    Vector3f poshder =new Vector3f(0.155f, 0.115f, 0);
    Transform3D t3d3HD=new Transform3D();
    t3d3HD.set(1,poshder);
    TransformGroup tg3HD=new TransformGroup(t3d3HD);
    Transform3D t3d2HD=new Transform3D();
    t3d2HD.rotX(nAnguloDoor);
    tg2HD=new TransformGroup(t3d2HD);
    tg2HD.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
    Transform3D t3d1HD=new Transform3D();
    t3d1HD.set(1,new Vector3d(0.0f,0,0));
    TransformGroup tg1HD=new TransformGroup(t3d1HD);
 Sphere hder=new Sphere(.03f,Primitive.GENERATE_NORMALS, 32,yellowSphAppearance);
    tg1HD.addChild(hder);
    tg3HD.addChild(tg2HD);
    tg2HD.addChild(tg1HD);

    tg1Tron.addChild(tg3HD);

    //Brazo Derecho
    Vector3f posbder =new Vector3f(0.0f,-0.075f,0f);
    Transform3D t3d11HD=new Transform3D();
    t3d11HD.set(1,posbder);
    tg11HD=new TransformGroup(t3d11HD);

    tg11HD.setCapability(BranchGroup.ALLOW_CHILDREN_READ);
    tg11HD.setCapability(BranchGroup.ALLOW_CHILDREN_WRITE);
    tg11HD.setCapability(BranchGroup.ALLOW_CHILDREN_EXTEND);
    tg11HD.setCapability(BranchGroup.ALLOW_DETACH);


    Cylinder bder=new Cylinder(0.0125f,0.15f ,yellowSphAppearance);
    tg11HD.addChild(bder);
    tg1HD.addChild(tg11HD);
    Vector3f posbala =new Vector3f(0.0f,-0.075f,0f);
    

/*
    Transform3D t3dbala=new Transform3D();
    t3dbala.set(1,posbala);
    tgbala=new TransformGroup(t3dbala);
 */   
    //tgbala.setCapability(BranchGroup.ALLOW_DETACH);
    /*mar 2017 lb=new LaserBeam(new Vector3d(0,0,0),null);
    t3dbala=lb.getBeamTD3();*/
    
/*  tgbala.addChild(lb.getBeamBG());
    bgBala=new BranchGroup();
    bgBala.setCapability(BranchGroup.ALLOW_CHILDREN_READ);
    bgBala.setCapability(BranchGroup.ALLOW_CHILDREN_WRITE);
    bgBala.setCapability(BranchGroup.ALLOW_CHILDREN_EXTEND);
    bgBala.setCapability(BranchGroup.ALLOW_DETACH );
    bgBala.addChild(tgbala);*/
    
    /*mar 2017 bgBala=translate1(lb.getBeamBG(), posbala);
    
    tg11HD.addChild(bgBala);*/
    
     /*
    		Transform3D transform3D = new Transform3D();
		transform3D.setTranslation(vector);
                 Transform3D t3d11HD=new Transform3D();
    		 t3d11HD.set(1,posbder);
		TransformGroup transformGroup =new TransformGroup();
		transformGroup.setTransform(transform3D);
                 tgbala=new TransformGroup(t3dbala);
		transformGroup.addChild(node);
                tgbala.addChild(lb.getBeamBG());
 
		BranchGroup branchGroup=new BranchGroup();
		branchGroup.setCapability(BranchGroup.ALLOW_DETACH );
                 bgBala=new BranchGroup();
    bgBala.setCapability(BranchGroup.ALLOW_DETACH );
		branchGroup.addChild(transformGroup);
		bgBala.addChild(tgbala);*/

//Hombro Izquiedo
 Vector3f poshizq =new Vector3f(-0.155f, 0.115f, 0);
    Transform3D t3d3HI=new Transform3D();
    t3d3HI.set(1,poshizq);
    TransformGroup tg3HI=new TransformGroup(t3d3HI);
    Transform3D t3d2HI=new Transform3D();
    t3d2HI.rotX(nAnguloDoor);
    tg2HI=new TransformGroup(t3d2HI);
    tg2HI.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
    Transform3D t3d1HI=new Transform3D();
    t3d1HI.set(1,new Vector3d(0.0f,0,0));
    TransformGroup tg1HI=new TransformGroup(t3d1HI);
 Sphere hizq=new Sphere(.03f,Primitive.GENERATE_NORMALS, 32,yellowSphAppearance);
    tg1HI.addChild(hizq);
    //tran.addChild(tg3HI);
    tg3HI.addChild(tg2HI);
    tg2HI.addChild(tg1HI);

    tg1Tron.addChild(tg3HI);

    //Brazo Izquiedo
    Vector3f posbizq =new Vector3f(0.0f,-0.075f,0f);
    Transform3D t3d11HI=new Transform3D();
    t3d11HI.set(1,posbizq);
    TransformGroup tg11HI=new TransformGroup(t3d11HI);
    Cylinder bizq=new Cylinder(0.0125f,0.15f ,yellowSphAppearance);
    tg11HI.addChild(bizq);
    tg1HI.addChild(tg11HI);

         /*Hombro Izquiedo
         homizq.setTranslation(poshizq);
         TransformGroup transformacion5= new TransformGroup(homizq);
         Sphere hizq=new Sphere(.03f,Primitive.GENERATE_NORMALS, 32,yellowSphAppearance);
         transformacion5.addChild(hizq);       
         tran.addChild(transformacion5);

         Brazo Izquierdo
         braizq.setTranslation(posbizq);
         TransformGroup transformacion7= new TransformGroup(braizq);
         Cylinder bizq=new Cylinder(0.0125f,0.15f ,yellowSphAppearance);
         transformacion7.addChild(bizq);
         tran.addChild(transformacion7);
*/
         //Pierna Derecha
	Vector3f pospder =new Vector3f(0.05f,-0.15f,0f);
         pieder.setTranslation(pospder);
         TransformGroup transformacion8= new TransformGroup(pieder);
         Cylinder pder=new Cylinder(0.0125f,0.1225f ,yellowSphAppearance);
         transformacion8.addChild(pder);
	 tg1Tron.addChild(transformacion8);
         //Pierna Izquierda
         Vector3f pospizq =new Vector3f(-0.05f,-0.15f,0);
         pieizq.setTranslation(pospizq);
         TransformGroup transformacion9= new TransformGroup(pieizq);
         Cylinder pizq=new Cylinder(0.0125f,0.1225f ,yellowSphAppearance);
         transformacion9.addChild(pizq);
         tg1Tron.addChild(transformacion9);
         texto(nombre_mostrar, new Vector3f(x-0.085f,y-0.33f,z), 24);
         mensaje("chat chat chat");
         group.addChild(tran);
         if(movimiento){
         transformacion2.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
         transformacion2.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
         //transformacion3.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
         //transformacion3.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
         //transformacion4.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
         //transformacion4.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
         //transformacion5.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
         //transformacion5.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
         tg2HD.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
         tg2HD.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
         tg2HI.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
         tg2HI.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
         transformacion8.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
         transformacion8.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
         transformacion9.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
         transformacion9.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
         //transformacion10.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
         MouseTranslate t2=new MouseTranslate(transformacion2);
         //MouseTranslate t3=new MouseTranslate(transformacion3);
         //MouseTranslate t4=new MouseTranslate(transformacion4);
         //MouseTranslate t5=new MouseTranslate(transformacion5);
         MouseTranslate t6=new MouseTranslate(tg2HD);
         MouseTranslate t7=new MouseTranslate(tg2HI);
         MouseTranslate t8=new MouseTranslate(transformacion8);
         MouseTranslate t9=new MouseTranslate(transformacion9);
         //MouseTranslate t10=new MouseTranslate(transformacion10);
         t2.setSchedulingBounds(bounds);
         tran.addChild(t2);
         //t3.setSchedulingBounds(bounds);
         //tran.addChild(t3);
         //t4.setSchedulingBounds(bounds);
         //tran.addChild(t4);
         //t5.setSchedulingBounds(bounds);
         //tran.addChild(t5);
         t6.setSchedulingBounds(bounds);
         tran.addChild(t6);
         t7.setSchedulingBounds(bounds);
         tran.addChild(t7);
         t8.setSchedulingBounds(bounds);
         tran.addChild(t8);
         t9.setSchedulingBounds(bounds);
         tran.addChild(t9);
         //t10.setSchedulingBounds(bounds);
         //tran.addChild(t10); 
        }
    }
    public BranchGroup myBody(){
        return group;
    }
    public void texto(String mensaje, Vector3f v, int tam) {
          
         Text2D textObject = new Text2D(mensaje, new Color3f(.4f, 0.4f, 0.6f),
        "Serif", tam, Font.ITALIC);
    
    Transform3D textTranslation = new Transform3D();
    textTranslation.setTranslation(v);
    TransformGroup textTranslationGroup = new TransformGroup(textTranslation);
    textTranslationGroup.addChild(textObject);
    tran.addChild(textTranslationGroup);
    }
    public void mensaje(String mensaje) {
          
         textObject = new Text2D(mensaje, new Color3f(.4f, 0.4f, 0.6f),
        "Serif", 28, Font.ITALIC);
    Appearance ap = textObject.getAppearance();
    ap.setCapability(Appearance.ALLOW_TEXTURE_ATTRIBUTES_WRITE);
    ap.setCapability(Appearance.ALLOW_TEXTURE_WRITE);
    ap.setCapability(Appearance.ALLOW_MATERIAL_WRITE);
    Transform3D textTranslation = new Transform3D();
    textTranslation.setTranslation(new Vector3f(x-0.4f,y+0.25f,z));
    TransformGroup textTranslationGroup = new TransformGroup(textTranslation);
    textTranslationGroup.addChild(textObject);
    tran.addChild(textTranslationGroup);
    }
    public void aviso(String mensaje){	
	textObject.setString(mensaje) ;
    }
    public void addObjects1(String mensaje) {
		Font3D f3d = new Font3D(new Font("TestFont", Font.PLAIN, 2),
				new FontExtrusion());
		Text3D text = new Text3D(f3d, new String(mensaje), new Point3f(0f,0f,0f));	 
		text.setString(mensaje);
		Color3f white = new Color3f(1.0f, 1.0f, 1.0f);
		Color3f blue = new Color3f(.2f, 0.2f, 0.6f);
		Appearance a = new Appearance();
		Material m = new Material(blue, blue, blue, white, 80.0f);
		m.setLightingEnable(true);
		a.setMaterial(m);

		Shape3D sh = new Shape3D();
		sh.setGeometry(text);
		sh.setAppearance(a);
		TransformGroup tg = new TransformGroup();
		Transform3D t3d = new Transform3D();
		Transform3D tDown = new Transform3D();
		Transform3D rot = new Transform3D();
		Vector3f v3f = new Vector3f(0.0f, 0.0f, 0.0f);
                //Vector3f v3f = new Vector3f(x-0.085f,y-0.33f,z);
		t3d.setTranslation(v3f);
		rot.rotX(Math.PI *0.0f);
		t3d.mul(rot);
		v3f = new Vector3f(0, 0f, 0f);
		tDown.setTranslation(v3f);
		t3d.mul(tDown);
		tg.setTransform(t3d);
		tg.addChild(sh);
		tran.addChild(tg);
		
	}
    public void changeTextureCab(Texture texture, String image) {
        loader = new TextureLoader(image, "RGB",frame1);
    	texture = loader.getTexture();
	texture.setBoundaryModeS(Texture.CLAMP_TO_BOUNDARY);
	texture.setBoundaryModeT(Texture.CLAMP_TO_BOUNDARY);
	texture.setBoundaryColor(new Color4f(0.0f, 1.0f, 0.5f, 0f));
	TextureAttributes texAttr = new TextureAttributes();
	texAttr.setTextureMode(TextureAttributes.REPLACE);
	ap.setTextureAttributes(texAttr);
	ap.setTexture(texture);
    }
    BranchGroup translate1(Node node, Vector3f vector) {
		Transform3D transform3D = new Transform3D();
		transform3D.setTranslation(vector);
		TransformGroup transformGroup =new TransformGroup();
		transformGroup.setTransform(transform3D);
		transformGroup.addChild(node);
		BranchGroup branchGroup=new BranchGroup();
	 		
		//branchGroup.setCapability(BranchGroup.ALLOW_CHILDREN_READ);
		//branchGroup.setCapability(BranchGroup.ALLOW_CHILDREN_WRITE);
		branchGroup.setCapability(BranchGroup.ALLOW_DETACH );

		branchGroup.addChild(transformGroup);
	return branchGroup;
	}
}
