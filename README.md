# class-hex-viewer

#### 介绍
class字节码解析,通过class文件读取文件结构,转换为json,通过网页方式浏览
项目第一期计划分为以下几项：
- ~~完整解析字节码~~
- 设计页面与数据库表
- 将json转化为页面可读信息


---

## 属性解析已完成

<p style="color: red;">* module与RuntimeTypeAnnotations未测试</p>

[查看链接jvm16 🔗](https://docs.oracle.com/javase/specs/jvms/se16/html/jvms-4.html#jvms-4.7)




---

> 示例展示:读取class文件后生成的json串

```json
{
  "offset" : 0,
  "size" : 528,
  "magicNumber" : {
    "offset" : 0,
    "size" : 4,
    "description" : "0XCAFEBABE",
    "value" : 3405691582
  },
  "minorVersion" : {
    "offset" : 4,
    "size" : 2,
    "description" : "0",
    "value" : 0
  },
  "majorVersion" : {
    "offset" : 6,
    "size" : 2,
    "description" : "1.8",
    "value" : 52
  },
  "constantPoolCount" : {
    "offset" : 8,
    "size" : 2,
    "description" : "34",
    "value" : 34
  },
  "constantPool" : {
    "offset" : 10,
    "size" : 331,
    "constantInfoList" : [ {
      "offset" : 10,
      "size" : 5,
      "tag" : {
        "offset" : 10,
        "size" : 1,
        "description" : "10",
        "value" : 10
      },
      "classInfo" : {
        "offset" : 11,
        "size" : 2,
        "description" : "cp_info #7",
        "value" : 7
      },
      "nameAndType" : {
        "offset" : 13,
        "size" : 2,
        "description" : "cp_info #17",
        "value" : 17
      }
    }, {
      "offset" : 15,
      "size" : 3,
      "description" : "cp_info #18",
      "tag" : {
        "offset" : 15,
        "size" : 1,
        "description" : "8",
        "value" : 8
      }
    }, {
      "offset" : 18,
      "size" : 5,
      "tag" : {
        "offset" : 18,
        "size" : 1,
        "description" : "9",
        "value" : 9
      },
      "classInfo" : {
        "offset" : 19,
        "size" : 2,
        "description" : "cp_info #19",
        "value" : 19
      },
      "nameAndType" : {
        "offset" : 21,
        "size" : 2,
        "description" : "cp_info #20",
        "value" : 20
      }
    }, {
      "offset" : 23,
      "size" : 5,
      "tag" : {
        "offset" : 23,
        "size" : 1,
        "description" : "10",
        "value" : 10
      },
      "classInfo" : {
        "offset" : 24,
        "size" : 2,
        "description" : "cp_info #21",
        "value" : 21
      },
      "nameAndType" : {
        "offset" : 26,
        "size" : 2,
        "description" : "cp_info #22",
        "value" : 22
      }
    }, {
      "offset" : 28,
      "size" : 5,
      "tag" : {
        "offset" : 28,
        "size" : 1,
        "description" : "10",
        "value" : 10
      },
      "classInfo" : {
        "offset" : 29,
        "size" : 2,
        "description" : "cp_info #21",
        "value" : 21
      },
      "nameAndType" : {
        "offset" : 31,
        "size" : 2,
        "description" : "cp_info #23",
        "value" : 23
      }
    }, {
      "offset" : 33,
      "size" : 3,
      "tag" : {
        "offset" : 33,
        "size" : 1,
        "description" : "7",
        "value" : 7
      },
      "index" : {
        "offset" : 34,
        "size" : 2,
        "description" : "cp_info #24",
        "value" : 24
      }
    }, {
      "offset" : 36,
      "size" : 3,
      "tag" : {
        "offset" : 36,
        "size" : 1,
        "description" : "7",
        "value" : 7
      },
      "index" : {
        "offset" : 37,
        "size" : 2,
        "description" : "cp_info #25",
        "value" : 25
      }
    }, {
      "offset" : 39,
      "size" : 3,
      "tag" : {
        "offset" : 39,
        "size" : 1,
        "description" : "7",
        "value" : 7
      },
      "index" : {
        "offset" : 40,
        "size" : 2,
        "description" : "cp_info #26",
        "value" : 26
      }
    }, {
      "offset" : 42,
      "size" : 9,
      "description" : "<init>",
      "tag" : {
        "offset" : 42,
        "size" : 1,
        "description" : "1",
        "value" : 1
      },
      "length" : {
        "offset" : 43,
        "size" : 2,
        "description" : "6",
        "value" : 6
      },
      "bytes" : {
        "offset" : 45,
        "size" : 6,
        "description" : "<init>"
      }
    }, {
      "offset" : 51,
      "size" : 6,
      "description" : "()V",
      "tag" : {
        "offset" : 51,
        "size" : 1,
        "description" : "1",
        "value" : 1
      },
      "length" : {
        "offset" : 52,
        "size" : 2,
        "description" : "3",
        "value" : 3
      },
      "bytes" : {
        "offset" : 54,
        "size" : 3,
        "description" : "()V"
      }
    }, {
      "offset" : 57,
      "size" : 7,
      "description" : "Code",
      "tag" : {
        "offset" : 57,
        "size" : 1,
        "description" : "1",
        "value" : 1
      },
      "length" : {
        "offset" : 58,
        "size" : 2,
        "description" : "4",
        "value" : 4
      },
      "bytes" : {
        "offset" : 60,
        "size" : 4,
        "description" : "Code"
      }
    }, {
      "offset" : 64,
      "size" : 18,
      "description" : "LineNumberTable",
      "tag" : {
        "offset" : 64,
        "size" : 1,
        "description" : "1",
        "value" : 1
      },
      "length" : {
        "offset" : 65,
        "size" : 2,
        "description" : "15",
        "value" : 15
      },
      "bytes" : {
        "offset" : 67,
        "size" : 15,
        "description" : "LineNumberTable"
      }
    }, {
      "offset" : 82,
      "size" : 7,
      "description" : "main",
      "tag" : {
        "offset" : 82,
        "size" : 1,
        "description" : "1",
        "value" : 1
      },
      "length" : {
        "offset" : 83,
        "size" : 2,
        "description" : "4",
        "value" : 4
      },
      "bytes" : {
        "offset" : 85,
        "size" : 4,
        "description" : "main"
      }
    }, {
      "offset" : 89,
      "size" : 25,
      "description" : "([Ljava/lang/String;)V",
      "tag" : {
        "offset" : 89,
        "size" : 1,
        "description" : "1",
        "value" : 1
      },
      "length" : {
        "offset" : 90,
        "size" : 2,
        "description" : "22",
        "value" : 22
      },
      "bytes" : {
        "offset" : 92,
        "size" : 22,
        "description" : "([Ljava/lang/String;)V"
      }
    }, {
      "offset" : 114,
      "size" : 13,
      "description" : "SourceFile",
      "tag" : {
        "offset" : 114,
        "size" : 1,
        "description" : "1",
        "value" : 1
      },
      "length" : {
        "offset" : 115,
        "size" : 2,
        "description" : "10",
        "value" : 10
      },
      "bytes" : {
        "offset" : 117,
        "size" : 10,
        "description" : "SourceFile"
      }
    }, {
      "offset" : 127,
      "size" : 12,
      "description" : "Test.java",
      "tag" : {
        "offset" : 127,
        "size" : 1,
        "description" : "1",
        "value" : 1
      },
      "length" : {
        "offset" : 128,
        "size" : 2,
        "description" : "9",
        "value" : 9
      },
      "bytes" : {
        "offset" : 130,
        "size" : 9,
        "description" : "Test.java"
      }
    }, {
      "offset" : 139,
      "size" : 5,
      "tag" : {
        "offset" : 139,
        "size" : 1,
        "description" : "12",
        "value" : 12
      },
      "name" : {
        "offset" : 140,
        "size" : 2,
        "description" : "cp_info #9",
        "value" : 9
      },
      "describe" : {
        "offset" : 142,
        "size" : 2,
        "description" : "cp_info #10",
        "value" : 10
      }
    }, {
      "offset" : 144,
      "size" : 15,
      "description" : "Hello World!",
      "tag" : {
        "offset" : 144,
        "size" : 1,
        "description" : "1",
        "value" : 1
      },
      "length" : {
        "offset" : 145,
        "size" : 2,
        "description" : "12",
        "value" : 12
      },
      "bytes" : {
        "offset" : 147,
        "size" : 12,
        "description" : "Hello World!"
      }
    }, {
      "offset" : 159,
      "size" : 3,
      "tag" : {
        "offset" : 159,
        "size" : 1,
        "description" : "7",
        "value" : 7
      },
      "index" : {
        "offset" : 160,
        "size" : 2,
        "description" : "cp_info #27",
        "value" : 27
      }
    }, {
      "offset" : 162,
      "size" : 5,
      "tag" : {
        "offset" : 162,
        "size" : 1,
        "description" : "12",
        "value" : 12
      },
      "name" : {
        "offset" : 163,
        "size" : 2,
        "description" : "cp_info #28",
        "value" : 28
      },
      "describe" : {
        "offset" : 165,
        "size" : 2,
        "description" : "cp_info #29",
        "value" : 29
      }
    }, {
      "offset" : 167,
      "size" : 3,
      "tag" : {
        "offset" : 167,
        "size" : 1,
        "description" : "7",
        "value" : 7
      },
      "index" : {
        "offset" : 168,
        "size" : 2,
        "description" : "cp_info #30",
        "value" : 30
      }
    }, {
      "offset" : 170,
      "size" : 5,
      "tag" : {
        "offset" : 170,
        "size" : 1,
        "description" : "12",
        "value" : 12
      },
      "name" : {
        "offset" : 171,
        "size" : 2,
        "description" : "cp_info #31",
        "value" : 31
      },
      "describe" : {
        "offset" : 173,
        "size" : 2,
        "description" : "cp_info #32",
        "value" : 32
      }
    }, {
      "offset" : 175,
      "size" : 5,
      "tag" : {
        "offset" : 175,
        "size" : 1,
        "description" : "12",
        "value" : 12
      },
      "name" : {
        "offset" : 176,
        "size" : 2,
        "description" : "cp_info #31",
        "value" : 31
      },
      "describe" : {
        "offset" : 178,
        "size" : 2,
        "description" : "cp_info #33",
        "value" : 33
      }
    }, {
      "offset" : 180,
      "size" : 7,
      "description" : "Test",
      "tag" : {
        "offset" : 180,
        "size" : 1,
        "description" : "1",
        "value" : 1
      },
      "length" : {
        "offset" : 181,
        "size" : 2,
        "description" : "4",
        "value" : 4
      },
      "bytes" : {
        "offset" : 183,
        "size" : 4,
        "description" : "Test"
      }
    }, {
      "offset" : 187,
      "size" : 19,
      "description" : "java/lang/Object",
      "tag" : {
        "offset" : 187,
        "size" : 1,
        "description" : "1",
        "value" : 1
      },
      "length" : {
        "offset" : 188,
        "size" : 2,
        "description" : "16",
        "value" : 16
      },
      "bytes" : {
        "offset" : 190,
        "size" : 16,
        "description" : "java/lang/Object"
      }
    }, {
      "offset" : 206,
      "size" : 23,
      "description" : "java/io/Serializable",
      "tag" : {
        "offset" : 206,
        "size" : 1,
        "description" : "1",
        "value" : 1
      },
      "length" : {
        "offset" : 207,
        "size" : 2,
        "description" : "20",
        "value" : 20
      },
      "bytes" : {
        "offset" : 209,
        "size" : 20,
        "description" : "java/io/Serializable"
      }
    }, {
      "offset" : 229,
      "size" : 19,
      "description" : "java/lang/System",
      "tag" : {
        "offset" : 229,
        "size" : 1,
        "description" : "1",
        "value" : 1
      },
      "length" : {
        "offset" : 230,
        "size" : 2,
        "description" : "16",
        "value" : 16
      },
      "bytes" : {
        "offset" : 232,
        "size" : 16,
        "description" : "java/lang/System"
      }
    }, {
      "offset" : 248,
      "size" : 6,
      "description" : "out",
      "tag" : {
        "offset" : 248,
        "size" : 1,
        "description" : "1",
        "value" : 1
      },
      "length" : {
        "offset" : 249,
        "size" : 2,
        "description" : "3",
        "value" : 3
      },
      "bytes" : {
        "offset" : 251,
        "size" : 3,
        "description" : "out"
      }
    }, {
      "offset" : 254,
      "size" : 24,
      "description" : "Ljava/io/PrintStream;",
      "tag" : {
        "offset" : 254,
        "size" : 1,
        "description" : "1",
        "value" : 1
      },
      "length" : {
        "offset" : 255,
        "size" : 2,
        "description" : "21",
        "value" : 21
      },
      "bytes" : {
        "offset" : 257,
        "size" : 21,
        "description" : "Ljava/io/PrintStream;"
      }
    }, {
      "offset" : 278,
      "size" : 22,
      "description" : "java/io/PrintStream",
      "tag" : {
        "offset" : 278,
        "size" : 1,
        "description" : "1",
        "value" : 1
      },
      "length" : {
        "offset" : 279,
        "size" : 2,
        "description" : "19",
        "value" : 19
      },
      "bytes" : {
        "offset" : 281,
        "size" : 19,
        "description" : "java/io/PrintStream"
      }
    }, {
      "offset" : 300,
      "size" : 10,
      "description" : "println",
      "tag" : {
        "offset" : 300,
        "size" : 1,
        "description" : "1",
        "value" : 1
      },
      "length" : {
        "offset" : 301,
        "size" : 2,
        "description" : "7",
        "value" : 7
      },
      "bytes" : {
        "offset" : 303,
        "size" : 7,
        "description" : "println"
      }
    }, {
      "offset" : 310,
      "size" : 24,
      "description" : "(Ljava/lang/String;)V",
      "tag" : {
        "offset" : 310,
        "size" : 1,
        "description" : "1",
        "value" : 1
      },
      "length" : {
        "offset" : 311,
        "size" : 2,
        "description" : "21",
        "value" : 21
      },
      "bytes" : {
        "offset" : 313,
        "size" : 21,
        "description" : "(Ljava/lang/String;)V"
      }
    }, {
      "offset" : 334,
      "size" : 7,
      "description" : "(I)V",
      "tag" : {
        "offset" : 334,
        "size" : 1,
        "description" : "1",
        "value" : 1
      },
      "length" : {
        "offset" : 335,
        "size" : 2,
        "description" : "4",
        "value" : 4
      },
      "bytes" : {
        "offset" : 337,
        "size" : 4,
        "description" : "(I)V"
      }
    } ]
  },
  "accessFlags" : {
    "offset" : 341,
    "size" : 2,
    "description" : "public super",
    "value" : 33
  },
  "thisClass" : {
    "offset" : 343,
    "size" : 2,
    "description" : "cp_info #6",
    "value" : 6
  },
  "superClass" : {
    "offset" : 345,
    "size" : 2,
    "description" : "cp_info #7",
    "value" : 7
  },
  "interfacesCount" : {
    "offset" : 347,
    "size" : 2,
    "description" : "1",
    "value" : 1
  },
  "interfaces" : {
    "offset" : 349,
    "size" : 2,
    "interfaceList" : [ {
      "offset" : 349,
      "size" : 2,
      "description" : "cp_info #8",
      "value" : 8
    } ]
  },
  "fieldsCount" : {
    "offset" : 351,
    "size" : 2,
    "description" : "0",
    "value" : 0
  },
  "methodCount" : {
    "offset" : 353,
    "size" : 2,
    "description" : "2",
    "value" : 2
  },
  "methodInfos" : {
    "offset" : 355,
    "size" : 163,
    "methodList" : [ {
      "offset" : 355,
      "size" : 43,
      "description" : "<init>",
      "accessFlags" : {
        "offset" : 355,
        "size" : 2,
        "description" : "public",
        "value" : 1
      },
      "nameIndex" : {
        "offset" : 357,
        "size" : 2,
        "description" : "cp_info #9",
        "value" : 9
      },
      "descriptorIndex" : {
        "offset" : 359,
        "size" : 2,
        "description" : "cp_info #10",
        "value" : 10
      },
      "attributes" : {
        "offset" : 363,
        "size" : 35,
        "attributesCount" : {
          "offset" : 361,
          "size" : 2,
          "description" : "1",
          "value" : 1
        },
        "attributeInfoList" : [ {
          "offset" : 363,
          "size" : 35,
          "description" : "Code",
          "attributeNameIndex" : {
            "offset" : 363,
            "size" : 2,
            "description" : "cp_info #11",
            "value" : 11
          },
          "attributeLength" : {
            "offset" : 365,
            "size" : 4,
            "description" : "29",
            "value" : 29
          },
          "maxStack" : {
            "offset" : 369,
            "size" : 2,
            "description" : "1",
            "value" : 1
          },
          "maxLocals" : {
            "offset" : 371,
            "size" : 2,
            "description" : "1",
            "value" : 1
          },
          "codeLength" : {
            "offset" : 373,
            "size" : 4,
            "description" : "5",
            "value" : 5
          },
          "codes" : [ "aload_0", "invokespecial #1", "\n", "\n", "return" ],
          "exceptionTableLength" : {
            "offset" : 382,
            "size" : 2,
            "description" : "0",
            "value" : 0
          },
          "attributes" : {
            "offset" : 386,
            "size" : 12,
            "attributesCount" : {
              "offset" : 384,
              "size" : 2,
              "description" : "1",
              "value" : 1
            },
            "attributeInfoList" : [ {
              "offset" : 386,
              "size" : 12,
              "description" : "LineNumberTable",
              "attributeNameIndex" : {
                "offset" : 386,
                "size" : 2,
                "description" : "cp_info #12",
                "value" : 12
              },
              "attributeLength" : {
                "offset" : 388,
                "size" : 4,
                "description" : "6",
                "value" : 6
              },
              "lineNumberTableLength" : {
                "offset" : 392,
                "size" : 2,
                "description" : "1",
                "value" : 1
              },
              "lineNumbers" : [ {
                "startPc" : {
                  "offset" : 394,
                  "size" : 2,
                  "description" : "0",
                  "value" : 0
                },
                "lineNumber" : {
                  "offset" : 396,
                  "size" : 2,
                  "description" : "3",
                  "value" : 3
                }
              } ]
            } ]
          }
        } ]
      }
    }, {
      "offset" : 398,
      "size" : 120,
      "description" : "main",
      "accessFlags" : {
        "offset" : 398,
        "size" : 2,
        "description" : "static public",
        "value" : 9
      },
      "nameIndex" : {
        "offset" : 400,
        "size" : 2,
        "description" : "cp_info #13",
        "value" : 13
      },
      "descriptorIndex" : {
        "offset" : 402,
        "size" : 2,
        "description" : "cp_info #14",
        "value" : 14
      },
      "attributes" : {
        "offset" : 406,
        "size" : 112,
        "attributesCount" : {
          "offset" : 404,
          "size" : 2,
          "description" : "1",
          "value" : 1
        },
        "attributeInfoList" : [ {
          "offset" : 406,
          "size" : 112,
          "description" : "Code",
          "attributeNameIndex" : {
            "offset" : 406,
            "size" : 2,
            "description" : "cp_info #11",
            "value" : 11
          },
          "attributeLength" : {
            "offset" : 408,
            "size" : 4,
            "description" : "106",
            "value" : 106
          },
          "maxStack" : {
            "offset" : 412,
            "size" : 2,
            "description" : "2",
            "value" : 2
          },
          "maxLocals" : {
            "offset" : 414,
            "size" : 2,
            "description" : "5",
            "value" : 5
          },
          "codeLength" : {
            "offset" : 416,
            "size" : 4,
            "description" : "42",
            "value" : 42
          },
          "codes" : [ "ldc #2", "\n", "astore_1", "getstatic #3", "\n", "\n", "aload_1", "invokevirtual #4", "\n", "\n", "bipush 12", "\n", "istore_2", "bipush 21", "\n", "istore_3", "iinc 2 by 1", "\n", "\n", "iinc 3 by 1", "\n", "\n", "iinc 2 by 5", "\n", "\n", "iinc 3 by -1", "\n", "\n", "iload_2", "iload_3", "iadd", "istore 4", "\n", "getstatic #3", "\n", "\n", "iload 4", "\n", "invokevirtual #5", "\n", "\n", "return" ],
          "exceptionTableLength" : {
            "offset" : 462,
            "size" : 2,
            "description" : "0",
            "value" : 0
          },
          "attributes" : {
            "offset" : 466,
            "size" : 52,
            "attributesCount" : {
              "offset" : 464,
              "size" : 2,
              "description" : "1",
              "value" : 1
            },
            "attributeInfoList" : [ {
              "offset" : 466,
              "size" : 52,
              "description" : "LineNumberTable",
              "attributeNameIndex" : {
                "offset" : 466,
                "size" : 2,
                "description" : "cp_info #12",
                "value" : 12
              },
              "attributeLength" : {
                "offset" : 468,
                "size" : 4,
                "description" : "46",
                "value" : 46
              },
              "lineNumberTableLength" : {
                "offset" : 472,
                "size" : 2,
                "description" : "11",
                "value" : 11
              },
              "lineNumbers" : [ {
                "startPc" : {
                  "offset" : 474,
                  "size" : 2,
                  "description" : "0",
                  "value" : 0
                },
                "lineNumber" : {
                  "offset" : 476,
                  "size" : 2,
                  "description" : "5",
                  "value" : 5
                }
              }, {
                "startPc" : {
                  "offset" : 478,
                  "size" : 2,
                  "description" : "3",
                  "value" : 3
                },
                "lineNumber" : {
                  "offset" : 480,
                  "size" : 2,
                  "description" : "6",
                  "value" : 6
                }
              }, {
                "startPc" : {
                  "offset" : 482,
                  "size" : 2,
                  "description" : "10",
                  "value" : 10
                },
                "lineNumber" : {
                  "offset" : 484,
                  "size" : 2,
                  "description" : "8",
                  "value" : 8
                }
              }, {
                "startPc" : {
                  "offset" : 486,
                  "size" : 2,
                  "description" : "13",
                  "value" : 13
                },
                "lineNumber" : {
                  "offset" : 488,
                  "size" : 2,
                  "description" : "9",
                  "value" : 9
                }
              }, {
                "startPc" : {
                  "offset" : 490,
                  "size" : 2,
                  "description" : "16",
                  "value" : 16
                },
                "lineNumber" : {
                  "offset" : 492,
                  "size" : 2,
                  "description" : "10",
                  "value" : 10
                }
              }, {
                "startPc" : {
                  "offset" : 494,
                  "size" : 2,
                  "description" : "19",
                  "value" : 19
                },
                "lineNumber" : {
                  "offset" : 496,
                  "size" : 2,
                  "description" : "11",
                  "value" : 11
                }
              }, {
                "startPc" : {
                  "offset" : 498,
                  "size" : 2,
                  "description" : "22",
                  "value" : 22
                },
                "lineNumber" : {
                  "offset" : 500,
                  "size" : 2,
                  "description" : "13",
                  "value" : 13
                }
              }, {
                "startPc" : {
                  "offset" : 502,
                  "size" : 2,
                  "description" : "25",
                  "value" : 25
                },
                "lineNumber" : {
                  "offset" : 504,
                  "size" : 2,
                  "description" : "14",
                  "value" : 14
                }
              }, {
                "startPc" : {
                  "offset" : 506,
                  "size" : 2,
                  "description" : "28",
                  "value" : 28
                },
                "lineNumber" : {
                  "offset" : 508,
                  "size" : 2,
                  "description" : "15",
                  "value" : 15
                }
              }, {
                "startPc" : {
                  "offset" : 510,
                  "size" : 2,
                  "description" : "33",
                  "value" : 33
                },
                "lineNumber" : {
                  "offset" : 512,
                  "size" : 2,
                  "description" : "16",
                  "value" : 16
                }
              }, {
                "startPc" : {
                  "offset" : 514,
                  "size" : 2,
                  "description" : "41",
                  "value" : 41
                },
                "lineNumber" : {
                  "offset" : 516,
                  "size" : 2,
                  "description" : "26",
                  "value" : 26
                }
              } ]
            } ]
          }
        } ]
      }
    } ]
  },
  "attributes" : {
    "offset" : 520,
    "size" : 8,
    "attributesCount" : {
      "offset" : 518,
      "size" : 2,
      "description" : "1",
      "value" : 1
    },
    "attributeInfoList" : [ {
      "offset" : 520,
      "size" : 8,
      "description" : "SourceFile",
      "attributeNameIndex" : {
        "offset" : 520,
        "size" : 2,
        "description" : "cp_info #15",
        "value" : 15
      },
      "attributeLength" : {
        "offset" : 522,
        "size" : 4,
        "description" : "2",
        "value" : 2
      },
      "sourceFileIndex" : {
        "offset" : 526,
        "size" : 2,
        "description" : "cp_info #16",
        "value" : 16
      }
    } ]
  }
}
```