package basics;

import java.util.ArrayList;
import java.util.List;

/**
 * Illustrates inner classes .. Inner class has a reference to its enclosing class
 * 
 * @author shivjaya
 *
 */
public class SocialNetwork {
	public class Member {
		String name;
		
		public Member(String name) {
			this.name = name;
		}
		
		public void leave() {
			SocialNetwork.this.members.remove(this);
			
			// same as members.remove(this)
		}
		
		public String toString() {
			return this.name;
		}
	}
	
	
	List<Member> members = new ArrayList<Member>();
	public Member addMember(String name) {
		Member m = new Member(name);
		this.members.add(m);
		return m;
	}
	
	public void list() {
		System.out.println(members);
	}
	
	public static void main(String [] args) {
		//SocialNetwork.Member m = new SocialNetwork.Member();
		SocialNetwork n = new SocialNetwork();
		Member m = n.addMember("Shiva");
		n.list();
		m.leave();
		n.list();
		
		
	}
}
