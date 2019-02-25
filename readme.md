# Single Lane Bridge Problem

What we want to achieve is having a single lane bridge with cars passing from each direction without crashes.

### No Crash Scenario
5 Red[200ms], 2 Blue[200ms]
```
RedCar1 is crossing the bridge
						                        BlueCar1 is waiting to cross the bridge
RedCar2 is waiting to cross the bridge
						                        BlueCar2 is waiting to cross the bridge
RedCar3 is waiting to cross the bridge
RedCar4 is waiting to cross the bridge
RedCar5 is waiting to cross the bridge
RedCar1 crossed the bridge
					                        	BlueCar2 is crossing the bridge
						                        BlueCar2 crossed the bridge
RedCar4 is crossing the bridge
RedCar4 crossed the bridge
						                        BlueCar1 is crossing the bridge
						                        BlueCar1 crossed the bridge
RedCar3 is crossing the bridge
RedCar3 crossed the bridge
RedCar2 is crossing the bridge
RedCar2 crossed the bridge
RedCar5 is crossing the bridge
RedCar5 crossed the bridge
```

### Variable Wait Time Scenario
5 Red[Var], 2 Blue[Var]
```
									BlueCar1 is crossing the bridge[10ms]
RedCar2 is waiting to cross the bridge
RedCar1 is crossing the bridge[8ms]
									BlueCar2 is waiting to cross the bridge
RedCar3 is waiting to cross the bridge
RedCar4 is waiting to cross the bridge
RedCar5 is waiting to cross the bridge
RedCar1 crossed the bridge
									BlueCar1 crossed the bridge
RedCar2 is crossing the bridge[30ms]
RedCar2 crossed the bridge
									BlueCar2 is crossing the bridge[22ms]
									BlueCar2 crossed the bridge
RedCar3 is crossing the bridge[11ms]
RedCar3 crossed the bridge
RedCar4 is crossing the bridge[4ms]
RedCar4 crossed the bridge
RedCar5 is crossing the bridge[29ms]
RedCar5 crossed the bridge
```
