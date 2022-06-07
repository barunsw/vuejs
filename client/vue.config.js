const { defineConfig } = require('@vue/cli-service')
const target = 'http://localhost:8080'

module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
    port: 8081,
    proxy: {
      '^/api': {
        target,
        changeOrigin: true
      }
    }
  }
})
