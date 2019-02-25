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
```
RedCar1 is crossing the bridge
RedCar1 crossed the bridge
									BlueCar1 is crossing the bridge
									BlueCar1 crossed the bridge
RedCar2 is waiting to cross the bridge
RedCar2 is crossing the bridge
RedCar2 crossed the bridge
									BlueCar2 is crossing the bridge
									BlueCar2 crossed the bridge
RedCar3 is crossing the bridge
RedCar3 crossed the bridge
RedCar4 is waiting to cross the bridge
RedCar4 is crossing the bridge
RedCar4 crossed the bridge
RedCar5 is crossing the bridge
RedCar5 crossed the bridge
```
