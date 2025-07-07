import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import AuthScreen from './screens/AuthScreen';
import ProfileScreen from './screens/ProfileScreen';
import * as Notifications from 'expo-notifications';
import { useEffect } from 'react';
import * as Device from 'expo-device';
import { Platform } from 'react-native';

const Stack = createNativeStackNavigator();

export default function App() {
  useEffect(() => {
    const registerForPushNotifications = async () => {
      if (Device.isDevice) {
        const { status: existingStatus } = await Notifications.getPermissionsAsync();
        let finalStatus = existingStatus;
        if (existingStatus !== 'granted') {
          const { status } = await Notifications.requestPermissionsAsync();
          finalStatus = status;
        }
        if (finalStatus !== 'granted') {
          alert('Không cấp quyền thông báo!');
          return;
        }
        const token = (await Notifications.getExpoPushTokenAsync()).data;
        console.log('Push token:', token);
        // Bạn có thể lưu token này vào Firestore
      }
    };

    registerForPushNotifications();
  }, []);
  return (
    <NavigationContainer>
      <Stack.Navigator initialRouteName="Auth">
        <Stack.Screen name="Auth" component={AuthScreen} />
        <Stack.Screen name="Profile" component={ProfileScreen} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}
