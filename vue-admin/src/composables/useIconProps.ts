import { reactive, toRefs } from 'vue'

export interface IconProps {
  width?: number
  height?: number
}

export function useIconProps(props: IconProps) {
  const defaultProps = reactive({
    width: props.width ?? 16,
    height: props.height ?? 16,
  })

  return toRefs(defaultProps)
}