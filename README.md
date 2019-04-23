This application is example for article
https://jollydroid.com/2019/04/23/reboot-yoga

Grant permissions:

```
adb shell dpm set-device-owner com.jollydroid.rebootyoga/.AdminReceiver
```

Reboot immediately:

```
adb shell "am broadcast -a com.jollydroid.REBOOT -n com.jollydroid.rebootyoga/.RebootReceiver"
```

Trigger watchdog (will reboot in 10 minutes after you break it):

```
while sleep 60
do
adb devices | egrep 'device$' | cut -f 1 | while read serial
    do
        echo -n | adb -s "$serial" shell "am broadcast -a com.jollydroid.PING -n com.jollydroid.rebootyoga/.PingReceiver"
    done
done
```

