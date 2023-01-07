import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Scanner;
public class Table {

	public int row;
	public int column;
	Object[]titles;
	Object[][]table;
	JTable jtable;
	boolean mark;

	public Table(int row,int column) {
		this.row=row;
		this.column=column+1;
		titles=new Object[this.column];
		table=new Object[this.row][this.column];
		formTable();
		this.jtable=new JTable(table,titles);
		Scanner sc=new Scanner(System.in);
		System.out.println("字符串是否大小写敏感 Y/N");
		String input=sc.next();
		mark=input.equals("Y")||input.equals("y");
		sc.close();
	}
	private Deque<Integer> changeTo(int column) {
		// TODO 自动生成的方法存根
		int temp=column;
		Deque<Integer> target=new ArrayDeque<>();
		if(column<26) {
			target.addFirst(0);
			target.addLast(column);
			return target;
		}
		else {
			while(temp>0) {
				target.addFirst(temp%26);
				temp/=26;
			}
			return target;
		}
	}
	private void formTable() {
		titles[0]="";
		for(int i=1;i<column;i++) {
			if(i<27) {
				titles[i]=String.valueOf((char)(64+i));
			}
			else {
				int mark=i-27;
				Deque<Integer>temp=changeTo(mark);
				Iterator<Integer>it=temp.iterator();
				StringBuilder saber=new StringBuilder();
				while(it.hasNext()) {
					saber.append((char)(it.next()+65));
				}
				titles[i]=saber.toString();
			}
		}
		for(int i=0;i<column;i++) {
			if(i==0) {
				for(int j=0;j<row;j++) {
					table[j][0]=j+1;
				}
			}
			else {
				for(int j=0;j<row;j++) {
					table[j][i]="";
				}
			}

		}
	}
	private JPanel formNorthPanel() {
		JButton increaseSortRow=new JButton("行升序");
		increaseSortRow.addActionListener(e -> {
			// TODO 自动生成的方法存根
		 int row=jtable.getSelectedRow();
		 for(int i=1;i<table[row].length;i++) {
			 for(int j=table[row].length-1;j>i;j--) {
				 try {
					double pre=Double.parseDouble(String.valueOf(table[row][j-1]));
					double aft=Double.parseDouble(String.valueOf(table[row][j]));
					if(pre>aft) {
						 Object temp=table[row][j];
						 table[row][j]=table[row][j-1];
						 table[row][j-1]=temp;
					}
				} catch (Exception e1) {
					try {
						double aft=Double.parseDouble(String.valueOf(table[row][j]));
						if (String.valueOf(table[row][j - 1]).equals("")) {
						}
						else{
								Object temp=table[row][j];
								table[row][j]=table[row][j-1];
								table[row][j-1]=temp;
							}

					} catch (Exception e2) {
						try {
							double pre=Double.parseDouble(String.valueOf(table[row][j-1]));
						} catch (Exception e3) {
							if(mark) {
								 if(String.valueOf(table[row][j-1]).compareTo(String.valueOf(table[row][j]))>0) {
									 Object temp=table[row][j];
									 table[row][j]=table[row][j-1];
									 table[row][j-1]=temp;
							}

							// TODO: handle exception
						}
							else {
								 if(String.valueOf(table[row][j-1]).toLowerCase().compareTo(String.valueOf(table[row][j]).toLowerCase())>0) {
									 Object temp=table[row][j];
									 table[row][j]=table[row][j-1];
									 table[row][j-1]=temp;
							}
							}
						// TODO: handle exception
					}
					// TODO: handle exception
				}
				}
			 }
		 }
		});
		JButton decreaseSortRow=new JButton("行降序");
		decreaseSortRow.addActionListener(e -> {
			// TODO 自动生成的方法存根
		 int row=jtable.getSelectedRow();
		 for(int i=1;i<table[row].length;i++) {
			 for(int j=table[row].length-1;j>i;j--) {
				 try {
						double pre=Double.parseDouble(String.valueOf(table[row][j-1]));
						double aft=Double.parseDouble(String.valueOf(table[row][j]));
						if(pre<aft) {
							 Object temp=table[row][j];
							 table[row][j]=table[row][j-1];
							 table[row][j-1]=temp;
						}
				} catch (Exception e1) {
					try {
						double pre=Double.parseDouble(String.valueOf(table[row][j-1]));
						if (String.valueOf(table[row][j]).equals("")) {

						}
						else{
							Object temp=table[row][j];
							table[row][j]=table[row][j-1];
							table[row][j-1]=temp;
						}
					} catch (Exception e2) {
						try {
							double aft=Double.parseDouble(String.valueOf(table[row][j]));
						} catch (Exception e3) {
							if(mark) {
								 if(String.valueOf(table[row][j-1]).compareTo(String.valueOf(table[row][j]))<0) {
									 Object temp=table[row][j];
									 table[row][j]=table[row][j-1];
									 table[row][j-1]=temp;
								// TODO: handle exception
							}
							}
							else {
								 if(String.valueOf(table[row][j-1]).toLowerCase().compareTo(String.valueOf(table[row][j]).toLowerCase())<0) {
									 Object temp=table[row][j];
									 table[row][j]=table[row][j-1];
									 table[row][j-1]=temp;
								// TODO: handle exception
							}
							}

						// TODO: handle exception
					}
					// TODO: handle exception
				}
				 }
			 }
		 }
		});
		JButton increaseSortColumn=new JButton("列升序");
		increaseSortColumn.addActionListener(e -> {
			// TODO 自动生成的方法存根
		 int column=jtable.getSelectedColumn();
		 for(int i=0;i<table.length;i++) {
			 for(int j=table.length-1;j>i;j--) {
				 try {
					double pre=Double.parseDouble(String.valueOf(table[j-1][column]));
					double aft=Double.parseDouble(String.valueOf(table[j][column]));
					if(pre>aft) {
						 Object temp=table[j][column];
						 table[j][column]=table[j-1][column];
						 table[j-1][column]=temp;
					}
				} catch (Exception e1) {
					try {
						double aft=Double.parseDouble(String.valueOf(table[j][column]));
						if (String.valueOf(table[j - 1][column]).equals("")){

						}
						else{
							Object temp=table[j][column];
							table[j][column]=table[j-1][column];
							table[j-1][column]=temp;
						}
					} catch (Exception e2) {
						try {
							double pre=Double.parseDouble(String.valueOf(table[j-1][column]));
						} catch (Exception e3) {
							if(mark) {
								 if(String.valueOf(table[j-1][column]).compareTo(String.valueOf(table[j][column]))>0) {
									 Object temp=table[j][column];
									 table[j][column]=table[j-1][column];
									 table[j-1][column]=temp;
								// TODO: handle exception
							}
							}
							else {
								if(String.valueOf(table[j-1][column]).toLowerCase().compareTo(String.valueOf(table[j][column]).toLowerCase())>0) {
									 Object temp=table[j][column];
									 table[j][column]=table[j-1][column];
									 table[j-1][column]=temp;
								// TODO: handle exception
							}
							}

						// TODO: handle exception
					}
					// TODO: handle exception
				}
				}
			 }
		 }
		});
		JButton decreaseSortColumn=new JButton("列降序");
		decreaseSortColumn.addActionListener(e -> {
			// TODO 自动生成的方法存根
		 int column=jtable.getSelectedColumn();
		 for(int i=0;i<table.length;i++) {
			 for(int j=table.length-1;j>i;j--) {
				 try {
						double pre=Double.parseDouble(String.valueOf(table[j-1][column]));
						double aft=Double.parseDouble(String.valueOf(table[j][column]));
						if(pre<aft) {
							 Object temp=table[j][column];
							 table[j][column]=table[j-1][column];
							 table[j-1][column]=temp;
						}
					} catch (Exception e1) {
						try {
							double pre=Double.parseDouble(String.valueOf(table[j-1][column]));
							if (String.valueOf(table[j][column]).equals("")){

							}
							else{
								Object temp=table[j][column];
								table[j][column]=table[j-1][column];
								table[j-1][column]=temp;
							}
						} catch (Exception e2) {
							try {
								double aft=Double.parseDouble(String.valueOf(table[j][column]));
							} catch (Exception e3) {
								if(mark) {
									 if(String.valueOf(table[j-1][column]).compareTo(String.valueOf(table[j][column]))<0) {
										 Object temp=table[j][column];
										 table[j][column]=table[j-1][column];
										 table[j-1][column]=temp;
									// TODO: handle exception
								}
								}
								else {
									 if(String.valueOf(table[j-1][column]).toLowerCase().compareTo(String.valueOf(table[j][column]).toLowerCase())<0) {
										 Object temp=table[j][column];
										 table[j][column]=table[j-1][column];
										 table[j-1][column]=temp;
									// TODO: handle exception
								}
								}

							// TODO: handle exception
						}
						// TODO: handle exception
					}
					}
				 }
			 }
			});
		JButton save=new JButton("保存");
		save.addActionListener(e -> {
			// TODO 自动生成的方法存根
			Outputter opr=new Outputter(Table.this);
			try {
				opr.ouput();
				System.out.println("保存成功");
			} catch (IOException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		});
		JPanel panel4=new JPanel();
		panel4.add(increaseSortRow);
		panel4.add(decreaseSortRow);
		panel4.add(increaseSortColumn);
		panel4.add(decreaseSortColumn);
		panel4.add(save);
		return panel4;
	}
	private JPanel formSouthPanel() {
		JButton addRow=new JButton("行求和");
		addRow.addActionListener(e -> {
			// TODO 自动生成的方法存根
			int row=jtable.getSelectedRow();
			double temp=0;
			for(int i=1;i<table[row].length;i++) {
				if(table[row][i].equals("")) {
				}
				else temp+=Double.parseDouble((String)table[row][i]);
			}
			System.out.println("该行的总和为："+temp);
		});
		JButton addColumn=new JButton("列求和");
		addColumn.addActionListener(e -> {
			// TODO 自动生成的方法存根
			int column=jtable.getSelectedColumn();
			double temp=0;
			for (Object[] objects : table) {
				if (objects[column].equals("")) {
				} else temp += Double.parseDouble((String) objects[column]);
			}
			System.out.println("该列的总和为："+temp);
		});
		JButton averageRow=new JButton("行平均");
        averageRow.addActionListener(e -> {
			// TODO 自动生成的方法存根
			int row=jtable.getSelectedRow();
			double temp=0;
			int mark=0;
			for(int i=1;i<table[row].length;i++) {
				if(table[row][i].equals("")) {
				}
				else {
					temp+=Double.parseDouble((String)table[row][i]);
					mark++;
				}
			}
			System.out.println("该行的平均为："+temp/mark);
		});
		
		JButton averageColumn=new JButton("列平均");
		averageColumn.addActionListener(e -> {
			// TODO 自动生成的方法存根
			int column=jtable.getSelectedColumn();
			double temp=0;
			int mark=0;
			for (Object[] objects : table) {
				if (objects[column].equals("")) {
				} else {
					temp += Double.parseDouble((String) objects[column]);
					mark++;
				}
			}
			System.out.println("该列的平均为："+temp/mark);
		});
		JButton maxRow=new JButton("行最大");
		maxRow.addActionListener(e -> {
			// TODO 自动生成的方法存根
			int row=jtable.getSelectedRow();
			int mark=1;
			while(table[row][mark].equals(""))++mark;
			double temp=Double.parseDouble((String)table[row][mark]);
			for(int i=1;i<table[row].length;i++) {
				if(table[row][i].equals("")) {
				}
				else if(Double.parseDouble((String)table[row][i])>temp)temp=Double.parseDouble((String)table[row][i]);
			}
			System.out.println("该行的最大值为："+temp);
		});
		JButton maxColumn=new JButton("列最大");
		maxColumn.addActionListener(e -> {
			// TODO 自动生成的方法存根
			int column=jtable.getSelectedColumn();
			int mark=0;
			while(table[mark][column].equals(""))++mark;
			double temp=Double.parseDouble((String)table[mark][column]);
			for (Object[] objects : table) {
				if (objects[column].equals("")) {
				} else if (Double.parseDouble((String) objects[column]) > temp)
					temp = Double.parseDouble((String) objects[column]);
			}
			System.out.println("该列的最大值为："+temp);
		});
		JButton minRow=new JButton("行最小");
		minRow.addActionListener(e -> {
			// TODO 自动生成的方法存根
			int row=jtable.getSelectedRow();
			int mark=1;
			while(table[row][mark].equals(""))++mark;
			double temp=Double.parseDouble((String)table[row][mark]);
			for(int i=1;i<table[row].length;i++) {
				if(table[row][i].equals("")) {
				}
				else if(Double.parseDouble((String)table[row][i])<temp)temp=Double.parseDouble((String)table[row][i]);
			}
			System.out.println("该行的最小值为："+temp);
		});
		JButton minColumn=new JButton("列最小");
		minColumn.addActionListener(e -> {
			// TODO 自动生成的方法存根
			int column=jtable.getSelectedColumn();
			int mark=0;
			while(table[mark][column].equals(""))++mark;
			double temp=Double.parseDouble((String)table[mark][column]);
			for (Object[] objects : table) {
				if (objects[column].equals("")) {
				} else if (Double.parseDouble((String) objects[column]) < temp)
					temp = Double.parseDouble((String) objects[column]);
			}
			System.out.println("该列的最小值为："+temp);
		});
		JPanel panel3=new JPanel();
		panel3.add(addRow);
		panel3.add(addColumn);
		panel3.add(maxRow);
		panel3.add(maxColumn);
		panel3.add(minRow);
		panel3.add(minColumn);
		panel3.add(averageRow);
		panel3.add(averageColumn);
		return panel3;
	}
	public void init() {
		JFrame jf=new JFrame("My Excel");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setBounds(200, 200, 800, 400);
		jf.add(new JScrollPane(jtable));
		jf.add(formNorthPanel(),BorderLayout.NORTH);
		jf.add(formSouthPanel(),BorderLayout.SOUTH);
		jf.setVisible(true);
	}
}
