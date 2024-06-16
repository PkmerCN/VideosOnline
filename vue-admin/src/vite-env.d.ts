/// <reference types="vite/client" />

interface ImportMetaEnv {
  readonly VITE_APP_TITLE: string
  readonly VITE_APP_API_URL: string
  readonly VITE_APP_TIMEOUT: number
  readonly VITE_APP_APP_PREVENT_DUPLICATE_SUBMISSIONS: number
  // more env variables...
}

interface ImportMeta {
  readonly env: ImportMetaEnv
}