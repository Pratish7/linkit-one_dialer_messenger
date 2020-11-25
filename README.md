# linkit-one_dialer_messenger
<h2>Requirements</h2>
Mediatek Linkit-one with sim inserted.<br>
<h2>Description</h2>
A Program that helps you to make calls and send messages through linkit-one.
<h2>How to use</h2>
It uses JSerialCom library which is included.<br>
If using linux, run the command "sudo adduser <user_name> dialout" and reboot or log back in before running the program (only for the first time).<br>
Open the repo folder in VS code or add the JSerialCom jar file to path.<br>
To make calls, run "dialer.java", enter the number you wish to call and press "call".<br>
To send messages, run messenger.java, enter the number, write message body in respective fields and hit "send".<br>
<h2>Note</h2>
Do not run messenger.java and dialer.java simultaneously as it will show "Port busy" error.<br>
Close one before starting other.<br>
If you still get error or program misbehaves, reconnect the linkit-one module.<br>
