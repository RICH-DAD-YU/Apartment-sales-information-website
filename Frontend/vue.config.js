const { defineConfig } = require("@vue/cli-service");
module.exports = defineConfig({
  transpileDependencies: true,
  lintOnSave: false,
  outputDir: "C:/SSAFY/SpringBoot/Happy_House_6_Spring/src/main/resources/static",
  configureWebpack: {
    module: {
      rules: [
        {
          test: /\.css$/,
          use: ["postcss-loader"],
        },
      ],
    },
  },
});
