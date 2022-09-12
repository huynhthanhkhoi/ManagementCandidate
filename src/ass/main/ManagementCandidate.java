/*
 * @author KhoiHT2
 * @date 6 thg 9, 2022
 * @version 1.0
 */

package ass.main;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import ass.dao.CertificationImplDAO;
import ass.dao.ExperienceImplDAO;
import ass.dao.FresherImplDAO;
import ass.dao.InternImplDAO;
import ass.exception.BirthDayException;
import ass.exception.EmailException;
import ass.model.Candidate;
import ass.model.Certification;
import ass.model.Experience;
import ass.model.Fresher;
import ass.model.Intern;
import ass.services.ServicesImplDAO;
import ass.util.SQLCommand;
import ass.util.UserInput;

public class ManagementCandidate {	
	static ExperienceImplDAO exdao = new ExperienceImplDAO();
	static CertificationImplDAO ctdao = new CertificationImplDAO();
	static FresherImplDAO frdao = new FresherImplDAO();
	static InternImplDAO itdao = new InternImplDAO();
    static ServicesImplDAO svdao = new ServicesImplDAO();
	public static void main(String[] args) throws ParseException, SQLException {
		// down casting sử dung instanceof

//		Candidate c = new Experience();// => Upcasting
//		Experience ex1 = new Experience();
//		Candidate canex1 = ex1;
//		if (c instanceof Experience) {
//			Experience ex2 = (Experience) c; // => downcasting
//		}
//		Candidate canIntern = new Intern();
//		Experience exp3 = (Experience) canIntern;// => downcasting
		// - Candidate Management
		Date date = null;
		int choice;
		int candidateType;
		String loop = null;
		boolean check = false;
		String candidateID = null;
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		List<Certification> ctList = new ArrayList<Certification>();

		Scanner sc = new Scanner(System.in);
		do {
			getMenu();
			System.out.println("Enter your choice:");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Input type of candidate; 0: Experience; 1: Fresher; 2: Intern");
				candidateType = sc.nextInt();
				if (candidateType == 0) {
					Experience exp0 = new Experience();
					try {
						sc.nextLine();
						System.out.println("Please enter Experience ID: ");
						exp0.setCandidateID(sc.nextLine());
						System.out.println("Please enter Experience fullname: ");
						exp0.setFullName(sc.nextLine());
						String birthday;
						try {
							birthday = UserInput.checkBirthday1(sc);
							date = df.parse(birthday);
							exp0.setBirthDay(date);
							exp0.setCandidateType(candidateType);
						} catch (BirthDayException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							System.exit(0);
						}										
						try {
							exp0.setEmail(UserInput.checkEmail1(sc));
						} catch (EmailException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							System.exit(0);
						}
						System.out.println("Please enter Experience ExpInyear: ");
						exp0.setExpInYear(sc.nextInt());
						sc.nextLine();
						System.out.println("Please enter Experience proskill: ");
						exp0.setProSkill(sc.nextLine());	
					}catch(Exception e){
						System.out.println("The system has encountered an unexpected problem, sincerely sorry !!!”");
						System.exit(0);
					}
					
					check = exdao.addExperience(exp0);
					if (check) {
						candidateID = exp0.getCandidateID();
						System.out.println(" Add Experience successfull !");
					} else {
						System.out.println("Add Experience failed !");
					}
				} else if (candidateType == 1) {
					Fresher f1 = new Fresher();
					try {
						sc.nextLine();
						System.out.println("Please enter Fresher ID: ");
						f1.setCandidateID(sc.nextLine());
						System.out.println("Please enter Fresher fullname: ");
						f1.setFullName(sc.nextLine());
						String birthday = UserInput.checkBirthday(sc);					
						date = df.parse(birthday);
						f1.setBirthDay(date);
						f1.setCandidateType(candidateType);
						f1.setEmail(UserInput.checkEmail(sc));
						System.out.println("Enter Fresher graduationdate use string format like (01/01/1990)");
						String graduationDate = sc.nextLine();
						f1.setGraduationDate(df.parse(graduationDate));
						System.out.println("Enter graduation rank :");
						f1.setGraduationRank(sc.nextLine());
						System.out.println("Enter education :");
						f1.setEducation(sc.nextLine());
					} catch (Exception e) {
						System.out.println("The system has encountered an unexpected problem, sincerely sorry !!!");
					    System.exit(0);
					}
					
					check = frdao.addFresher(f1);
					if(check) {
						System.out.println("add Fresher sucessful !");
					}else {
						System.out.println("add fresher failure !");
					}

				} else {
					Intern it1 = new Intern();
					try {
						System.out.println("Please enter Intern ID: ");
						it1.setCandidateID(sc.nextLine());
						System.out.println("Please enter Intern fullname: ");
						it1.setFullName(sc.nextLine());
						String birthday = UserInput.checkBirthday(sc);
						date = df.parse(birthday);
						it1.setBirthDay(date);
						it1.setCandidateType(candidateType);
						it1.setEmail(UserInput.checkEmail(sc));
						System.out.println("Enter major:");
						it1.setMajor(sc.nextLine());
						sc.nextLine();
						System.out.println("Enter semester :");
						it1.setSemester(sc.nextInt());
						sc.nextLine();
						System.out.println("Enter Universityname :");
						it1.setUniversityName(sc.nextLine());
					} catch (Exception e) {
						System.out.println("The system has encountered an unexpected problem, sincerely sorry !!!");
					    System.exit(0);
					}
					sc.nextLine();
					
					check = itdao.addIntern(it1);
					if(check) {
						System.out.println("add Intern sucessful !");
					}else {
						System.out.println("add Intern failure !");
					}

				}
				do {
					Certification ct1 = new Certification();
					try {
						System.out.println("Please certificate of candidate");
						System.out.println("Enter certificateID : ");
						ct1.setCertificatedID(sc.nextLine());
						System.out.println("Enter certificate Name : ");
						ct1.setCertificatedName(sc.nextLine());
						System.out.println("Enter certificate Rank : ");
						ct1.setCertificatedRank(sc.nextLine());
						System.out.println("Enter certificate Date use string format examle: (01/01/1990) : ");
						String certifcateDate = sc.nextLine();
						ct1.setCertificatedDate(df.parse(certifcateDate));
						ct1.setCandidateID(candidateID);
					} catch (Exception e) {
						System.out.println("The system has encountered an unexpected problem, sincerely sorry !!!");
					    System.exit(0);
					}
					
					ctList.add(ct1);
					System.out.println("Do you want to continue adding (Y|N)?");
					loop = sc.nextLine();
				} while (loop.equals("Y") || loop.equals("y"));
				check = ctdao.addCertification(ctList);
				if (check) {
					System.out.println("add Certificate sucessful !");
				} else {
					System.out.println("add Certificate failure !");
				}	
				System.out.println("The number of candidate :  "  + Candidate.getCandidateCount());
				break;
			case 2:
				System.out.println(svdao.getFullName(SQLCommand.GET_NAME));
				
				break;
			case 3:
				int l = svdao.query(SQLCommand.GET_ALL).size();
				List<?> list = svdao.query(SQLCommand.GET_ALL);
				for(int i=0;i<l;i++) {
					System.out.println(list.get(i));
				}
				
				break;
			case 4:
				break;

			default:
				System.out.println("Invalid input!");
				break;
			}

		} while (true);

	}

	public static void getMenu() {
		System.out.println("-----Menu-----");
		System.out.println("1. Add candidate");
		System.out.println("2. Show all fullname of all candidate by string ");
		System.out.println("3. Show list candidate ");
//		    System.out.println("3. Delete one or more item(s) from a bill");
//		    System.out.println("4. Display all bills, sorted by created date");
//		    System.out.println("5. Display customer's bills, sorted by created date");
//		    System.out.println("6. Display items from a specific bill");
//		    System.out.println("7. Exit");
	}
}
