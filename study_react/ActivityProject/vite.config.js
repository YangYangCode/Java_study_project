import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [react()],
  server: {
    port: 5175, // 指定端口
  },
  css: {
    postcss: './postcss.config.js',
  },
  resolve: {
    alias: {
      $: 'jquery',
    },
  },
  css: {
    preprocessorOptions: {
      css: {
        // 這裡可以加入一些 CSS 預處理配置
      },
    },
  },
})
