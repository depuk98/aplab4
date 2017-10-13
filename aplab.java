import java.util.*;


abstract class animal implements Comparable<animal>{
	int time;int health;double x;double y; int type;int num;
	animal(int l,int m,int n,int o,int q,int kk){
		time=l;
		health=m;
		x=n;
		y=o;
		type=q;
		num=kk;
		
	}
	public int compareTo(animal b) {  
	    if(time>b.time){  
	        return 1;  
	    }else if(time<b.time){  
	        return -1;  
	    }else{
	    	if(health>b.health){
	    		return -1;
	    	}
	    	else if(health<b.health){
	    		return 1;
	    	}
	    	else{
	    		if(type>b.type){
	    			return 1;
	    		}
	    		else if(type<b.type){
	    			return -1;
	    		}
	    		else{
	    			int d1=(int) Math.sqrt((x*x)+(y*y));
	    			int d2=(int) Math.sqrt((b.x*b.x)+(b.y*b.y));
	    			if(d1>d2){
	    				return 1;
	    			}
	    			else{
	    				return -1;
	    			}
	    		}
	    	}
	    	
	    }  
	}
	
	
	
	
	void turn(int ancount,animal c1,animal c2, grassland gone, grassland gtwo) {
		// TODO Auto-generated method stub
		
	}    
} 




class herbivorous extends animal{ 
	int grasscap;
	static int turning;
herbivorous(int l, int m, int n, int o,int p,int k,int ll) {
		super(l, m, n, o,0,k);
		grasscap=p;
		turning=ll;//galat hai
	}

	 void turn(int ancount, animal c1, animal c2, grassland gone,grassland gtwo){
		if(ancount==0){
			double chance =Math.random();
			if(chance<=0.5){
				double dg1=Math.sqrt(Math.pow(x-gone.xcor,2)+Math.pow(y-gone.ycor,2));
				double dg2=Math.sqrt(Math.pow(x-gtwo.xcor,2)+Math.pow(y-gtwo.ycor,2));
				if(checker(gone,dg1)==1){
					move(gtwo,5);
				}
				else if(checker(gtwo,dg2)==1){
					move(gone,5);
				}
				else{
					if(dg1>dg2){
						move(gtwo,5);
					}
					else{move(gone,5);}
				}
			}
			
		}
		else{				
				double dg1=Math.sqrt(Math.pow(x-gone.xcor,2)+Math.pow(y-gone.ycor,2));
				double dg2=Math.sqrt(Math.pow(x-gtwo.xcor,2)+Math.pow(y-gtwo.ycor,2));
				turning++;
				if(checker(gone,dg1)==0 && checker(gtwo,dg2)==0){
					double chance2 =Math.random();
					if(chance2>0.05){
						double chance3 =Math.random();
						if(chance3<=0.65){
							if(dg1>dg2){
								move(gtwo,5);
							}
							else{move(gone,5);}
						}
						else{
							double dc1=Math.sqrt(Math.pow(x-c1.x,2)+Math.pow(y-c1.y,2));
							double dc2=Math.sqrt(Math.pow(x-c2.x,2)+Math.pow(y-c2.y,2));
							
							if(dc1>dc2){
								awaymove(c2,4);
							}
							else{
							awaymove(c1,4);	
							}
						}
						

					}
					
				}
				else{
					if(checker(gone,dg1)==1){
						if(gone.grass>=grasscap){
						double chance3 =Math.random();
						if(chance3<=0.9){
							gone.grass=gone.grass-grasscap;
							health=health+(health/2);
						}
						else{
							health=health-25;

							double chance4 =Math.random();
							double dc1=Math.sqrt(Math.pow(x-c1.x,2)+Math.pow(y-c1.y,2));
							double dc2=Math.sqrt(Math.pow(x-c2.x,2)+Math.pow(y-c2.y,2));
							
							if(chance4<=0.5){
								
								if(dc1>dc2){
									awaymove(c2,2);
								}
								else{
								awaymove(c1,2);	
								}
							}
							else{
								if(dg1>dg2){
									move(gtwo,3);
								}
								else{move(gone,3);}
							}	
						}
						}
						else{
							double chance4 =Math.random();
							if(chance4<=0.2){
								health=health+(health/5);
								gone.grass=0;
							}
							else{
								double dc1=Math.sqrt(Math.pow(x-c1.x,2)+Math.pow(y-c1.y,2));
								double dc2=Math.sqrt(Math.pow(x-c2.x,2)+Math.pow(y-c2.y,2));
								double chance5 =Math.random();
								if(chance5<=0.7){
									if(dc1>dc2){
										awaymove(c2,4);
									}
									else{
										awaymove(c1,4);	
									}								
									}
								else{
									if(dg1>dg2){
										move(gtwo,3);
									}
									else{move(gone,3);}
									
								}

								
							}

							
						}
					}
					else{
						if(gtwo.grass>=grasscap){
							double chance3 =Math.random();
							if(chance3<=0.9){
								gtwo.grass=gone.grass-grasscap;
								health=health+(health/2);

							}
							else{
								health=health-25;
								double chance4 =Math.random();
								double dc1=Math.sqrt(Math.pow(x-c1.x,2)+Math.pow(y-c1.y,2));
								double dc2=Math.sqrt(Math.pow(x-c2.x,2)+Math.pow(y-c2.y,2));
								
								if(chance4<=0.5){
									
									if(dc1>dc2){
										awaymove(c2,2);
									}
									else{
									awaymove(c1,2);	
									}
								}
								else{
									if(dg1>dg2){
										move(gtwo,3);
									}
									else{move(gone,3);}
								}	
							}
							}
							else{
								double chance4 =Math.random();
								if(chance4<=0.2){
									gtwo.grass=0;
									health=health+(health/5);
								}
								else{
									double dc1=Math.sqrt(Math.pow(x-c1.x,2)+Math.pow(y-c1.y,2));
									double dc2=Math.sqrt(Math.pow(x-c2.x,2)+Math.pow(y-c2.y,2));
									double chance5 =Math.random();
									if(chance5<=0.7){
										if(dc1>dc2){
											awaymove(c2,4);
										}
										else{
											awaymove(c1,4);	
										}								
										}
									else{
										if(dg1>dg2){
											move(gtwo,3);
										}
										else{move(gone,3);}
										
									}

									
								}

								
							}
					}
				}
		}
	}
	
	
	int checker(grassland gone, double dist){
		if(dist<gone.radius){
			return 1;
		}
		else{
			return 0;
		}
	}
	void move(grassland gone,int dist){
		double tan=(x-gone.xcor)/(y-gone.ycor);
		double secsqr=1+Math.pow(tan, 2);
		double cos=Math.sqrt(1/secsqr);
		double sin=tan*cos;
		x=x+dist*(sin);
		y=y+dist*(cos);
		
		
	}
	void awaymove(animal c1,int dist){
		double tan=(x-c1.x)/(y-c1.y);
		double secsqr=1+Math.pow(tan, 2);
		double cos=Math.sqrt(1/secsqr);
		double sin=tan*cos;
		x=x-dist*(sin);
		y=y-dist*(cos);
		
	}
}    





class carnivourous extends animal{    
carnivourous(int l, int m, int n, int o,int k) {
		super(l, m, n, o,1,k);
	}

void turn(int ancount, animal c1, animal c2, grassland gone,grassland gtwo){
	if(ancount!=0){
		double dh1=Math.sqrt(Math.pow(x-c1.x,2)+Math.pow(y-c1.y,2));
		double dh2=Math.sqrt(Math.pow(x-c2.x,2)+Math.pow(y-c2.y,2));
		if(dh1<=1 && dh2<=1){
			health=health+((health*2)/3);
			if(dh1<dh2){
				c1.health=0;
			}
			else{
				c2.health=0;
			}
		}
		else{
			double dg1=Math.sqrt(Math.pow(x-gone.xcor,2)+Math.pow(y-gone.ycor,2));
			double dg2=Math.sqrt(Math.pow(x-gtwo.xcor,2)+Math.pow(y-gtwo.ycor,2));
			if(checker(gone,dg1)==0 && checker(gone,dg1)==0){
				double chance =Math.random();
				if(chance<=0.92){
					if(dh1>dh2){
						move(c2,4);
						
					}
					else{
						move(c1,4);
					}
					
				}
				else
				{
					health-=60;
				}
	
			}
			else{
				if(checker(gone,dg1)==0){
					double chance =Math.random();
					if(chance<=0.75){
						if(dh1>dh2){
							move(c2,4);
							
						}
						else{
							move(c1,4);
						}
					}
					else{
						health-=30;
					}

				}
				else{
					double chance =Math.random();
					if(chance<=0.75){
						if(dh1>dh2){
							move(c2,4);
							
						}
						else{
							move(c1,4);
						}
					}
					else{
						health-=30;
					}
					
				}
			}
			
		}
	}
	}
int checker(grassland gone, double dist){
	if(dist<gone.radius){
		return 1;
	}
	else{
		return 0;
	}
}
void move(animal c1,int dist){
	double tan=(x-c1.x)/(y-c1.y);
	double secsqr=1+Math.pow(tan, 2);
	double cos=Math.sqrt(1/secsqr);
	double sin=tan*cos;
	x=x+dist*(sin);
	y=y+dist*(cos);
	
}
}




class grassland{
	int xcor; int ycor; int radius; int grass;
	grassland(int x,int y,int r,int g){
		x=xcor;
		y=ycor;
		radius=r;
		grass=g;
	}

}




public class Lab3 {
	static Scanner in=new Scanner(System.in);
	static int totaltime;
	static int carcount=2;
	static int hercount=2;
	static int maxtime=0;
	int flag=0;
	int flag2=0;
	

	public static void main(String[] args){
		System.out.println("MenuEnter Total Final Time for Simulation:");
		totaltime=in.nextInt();
		System.out.println("Enter x, y centre, radius and Grass Available for First Grassland:");
		int x1=in.nextInt();
		int y1=in.nextInt();
		int rr=in.nextInt();
		int av1=in.nextInt();
		grassland one=new grassland(x1,y1,rr,av1);
		System.out.println("Enter x, y centre, radius and Grass Available for Second Grassland:");
		int x2=in.nextInt();
		int y2=in.nextInt();
		int rr2=in.nextInt();
		int av2=in.nextInt();
		grassland two=new grassland(x2,y2,rr2,av2);
		System.out.println("Enter Health and Grass Capacity for Herbivores:");
		int healthherb=in.nextInt();
		int capa=in.nextInt();
		System.out.println("Enter x, y position and timestamp for First Herbivore:");
		int xh1=in.nextInt();
		int yh1=in.nextInt();
		int th1=in.nextInt();
		herbivorous h1=new herbivorous(th1,healthherb,xh1,yh1,capa,1,0);
		System.out.println("Enter x, y position and timestamp for Second Herbivore:");
		int xh2=in.nextInt();
		int yh2=in.nextInt();
		int th2=in.nextInt();
		herbivorous h2=new herbivorous(th2,healthherb,xh2,yh2,capa,2,0);
		System.out.println("Enter Health for Carnivores:");
		int healthcar =in.nextInt();
		System.out.println("Enter x, y position and timestamp for First Carnivore:");
		int xc1=in.nextInt();
		int yc1=in.nextInt();
		int tc1=in.nextInt();
		carnivourous c1=new carnivourous(tc1,healthcar,xc1,yc1,1);
		System.out.println("Enter x, y position and timestamp for Second Carnivore:");
		int xc2=in.nextInt();
		int yc2=in.nextInt();
		int tc2=in.nextInt();
		carnivourous c2=new carnivourous(tc2,healthcar,xc2,yc2,2);
		System.out.println("The Simulation Begins -");
	    Queue<animal> queue=new PriorityQueue<animal>();  
	    queue.add(h1);  
	    queue.add(h2);  
	    queue.add(c1);  
	    queue.add(c2);  
	    for(animal b:queue){
	    	if(b.time>maxtime){
	    		maxtime=b.time;
	    	}
	    	
	    }
	    
	    for(int i=0;i<totaltime;i++){
	    	if(queue.isEmpty()!=true){
	    		animal test=queue.remove();
	    		//System.out.println(test.type);

	    		if(test.type==0){
	    		hercount--;
	    		System.out.println("It is Herbivore"+test.num);
	    		if(herbivorous.turning>=7){
	    			test.health-=5;
	    		}

	    		test.turn(carcount,c1,c2,one,two);
	    		System.out.println("Its health after taking turn is "+test.health);
	    		if(test.health>0){
	    			queue.add(test);
    				test.time=(int)( maxtime+ (Math.random() * ( totaltime-maxtime )));

	    			hercount++;
	    		}
	    		else{
	    			System.out.println("It is dead");
	    		}
	    		System.out.println("");

	    		}
	    		else if(test.type==1){
	    			carcount--;
	    			System.out.println("It is Carnivorous."+test.num);
		    		

		    		test.turn(carcount,h1,h2,one,two);
		    		System.out.println("Its health after taking turn is "+test.health);
		    		if(test.health>0){
	    				test.time=(int)( maxtime+ (Math.random() * ( totaltime-maxtime )));
		    			queue.add(test);
		    			carcount++;
		    		}
		    		else{
		    			System.out.println("It is dead");
		    		}
		    		System.out.println("");

	    		}
	    		}
	    } 


		
	    //System.out.println(maxtime);


		
	}
}
