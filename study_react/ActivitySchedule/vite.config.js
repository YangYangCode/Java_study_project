import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [react()],
  server: {
    port: 5176, // 指定端口
  },
  css: {
    postcss: './postcss.config.js',
  },
})
