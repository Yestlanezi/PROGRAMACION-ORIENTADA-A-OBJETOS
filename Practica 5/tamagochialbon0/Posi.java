import javax.media.j3d.*;
import javax.vecmath.*;
public class Posi {
public static TransformGroup rotate(Node node, Alpha alpha) {
	TransformGroup xformGroup = new TransformGroup();
	xformGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
RotationInterpolator interpolator =new RotationInterpolator(alpha, xformGroup);
interpolator.setSchedulingBounds(new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 1.0));
	xformGroup.addChild(interpolator); xformGroup.addChild(node);
	return xformGroup; }
public static TransformGroup translate(Node node, Vector3f vector) {
	Transform3D transform3D = new Transform3D();
	transform3D.setTranslation(vector);
	TransformGroup transformGroup =new TransformGroup(transform3D);
        transformGroup.addChild(node);
	return transformGroup; 
} 
public static BranchGroup translate1(Node node, Vector3f vector) {
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
