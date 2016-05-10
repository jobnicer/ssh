package ssh;

import org.ssh.utils.ReflectTool;
import org.ssh.web.entity.Staff;

public class test {
	
	public static void main(String[] args) throws Exception {
		Staff staff = new Staff();
		staff.setId(1000L);
//		System.out.println(ReflectTool.getAttrClass(Staff.class, "id1"));
//		System.out.println(ReflectTool.getMehod(Staff.class, "id"));
		System.out.println(ReflectTool.getValue(staff, "id1"));
	}
}
	
