declare module "*.module.css";
declare module '*.jpg';
declare module '*.png';
declare module '*.scss' {
  const content: Record<string, string>;
  export default content;
}
// and so on for whatever flavor of css you're using