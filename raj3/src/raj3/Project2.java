package raj3;

 
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

import javax.swing.JScrollPane;

public class Project2 {

private JFrame frame;

/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
Project2 window = new Project2();
window.frame.setVisible(true);
}
 catch (Exception e) {
e.printStackTrace();
}
}
});
}

/**
* Create the application.
*/
public Project2() {
initialize();
}

/**
* Initialize the contents of the frame.
*/
private void initialize() {
frame = new JFrame();
frame.setBounds(100, 100, 450, 300);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.getContentPane().setLayout(null);

JScrollPane scrollPane = new JScrollPane();
scrollPane.setBounds(20, 43, 383, 207);
frame.getContentPane().add(scrollPane);

JTextArea textArea = new JTextArea();
scrollPane.setViewportView(textArea);

JButton btnRead = new JButton("CALCULATE THE GRADES");
btnRead.addActionListener(new ActionListener() {

public void actionPerformed(ActionEvent arg0) {
FileInputStream fstream = null;
try {
fstream = new FileInputStream("student_grades_input.txt");
}
 catch (FileNotFoundException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

String strLine;

try {
int i=0;


String result="";
String [] output  = new String[100];

int ace=0;
int bce=0;
int cce=0;
int dce=0;
int fce=0;
String GRADE="";
String A="A";
String B="B";
String C="C";
String D="D";
String F="F";
int count=0;
while ((strLine = br.readLine()) != null)   {

if(count<1){
//String use=strLine;

count=count+1;
}

else{

String [] tokens = strLine.split(",");


String Name = tokens[0];
String fHW1 = tokens[1];
String fHW2 = tokens[2];
String fHW3 = tokens[3];
String fMIDTERM = tokens[4];
String fPROJECT = tokens[5];
String fFIN = tokens[6];
String fFINAL=fFIN.trim();



int HW1 = Integer.parseInt(fHW1);
int HW2 = Integer.parseInt(fHW2);
int HW3 = Integer.parseInt(fHW3);
int Midterm = Integer.parseInt(fMIDTERM);
int Project = Integer.parseInt(fPROJECT);
int Final = Integer.parseInt(fFINAL);


float h=HW1+HW2+HW3;

float hw=h/3;

float x = (float) 0.45;
float HW= x * hw;

float mid=(Midterm+Final)/2;

float y=(float) 0.30;
float MID=y*mid;

float z=(float) 0.25;

float pro= z* Project;



float total =(HW +  pro + MID);



if(total>=90 && total<=100){

GRADE=A;

ace=ace+1;


}
if(total>=80 && total<=89){

GRADE=B;

bce=bce+1;


}
if(total>=70 && total<=79){
GRADE=C;

cce=cce+1;


}
if(total>=60 && total<=69){
GRADE=D;

dce=dce+1;


}
if(total<=59){
GRADE=F;

fce=fce+1;
}

String ans=("Name:"+Name+"\n"+"HW1="+fHW1+", "+"HW2="+fHW2+", "+"HW3="+fHW3+
", "+"MIDTERM="+fMIDTERM+", "+"PROJECT="+fPROJECT+", "
+"FINALS="+fFINAL+"\n"+"TOTAL="+total+", "+"GRADE="+GRADE+"\n"+"\n");

output[i]=ans;
result=result+output[i]+"\n";
i++;
}
}

String grades=("Number of A-grades:"+ace+"\n"+"Number of B-grades:"+bce+"\n"
+"Number of C-grades:"+cce+"\n"+"Number of D-grades:"+dce+"\n"
+"Number of F-grades:"+fce+"\n");

String finalresult=(result+"\n"+"\n"+"\n"+grades);
textArea.setText(String.valueOf(finalresult));

} 
catch (IOException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}

//Close the input stream
try {
br.close();
} catch (IOException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}
});
btnRead.setBounds(61, 11, 233, 23);
frame.getContentPane().add(btnRead);
}
}


