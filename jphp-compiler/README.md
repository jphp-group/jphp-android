## jphp-compiler

> AOT Compiler for jPHP

### How to build ?

Use ``jppm build`` command to build ``jphp-compiler``. Output ``jar`` file you can find on ``build`` directory.

### How to use ?

``jphp-compiler`` it\`s command-line application. 

Command-line arguments: 
  * --src      - path to directory witch php sources
  * --dest     - path to output directory (if ends ``.jar`` then create jar file)
  * --dest-res - (optional) path to output resursces

Before use compiler remove ``META-INF/MANIFEST.mf`` file!