import { execSync as exec } from 'node:child_process'
import logo from "./logo";
import { log } from "console"

/**
 * 1. 打印我们的logo
 * 2. 执行vite
 */
log(logo)
exec(`vite  --mode production`, { stdio: 'inherit' })