module.exports = function (api) {
  api.cache(true);
  return {
    presets: ['babel-preset-expo'],
    plugins: [['module:react-native-dotenv']],
  };
};

/**
 * ✅ Giải thích từng dòng:

presets: ['babel-preset-expo']
👉 Dùng preset mặc định của Expo để Babel hiểu React Native.

plugins: [['module:react-native-dotenv']]
👉 Cho phép bạn import biến môi trường từ file .env.
 */