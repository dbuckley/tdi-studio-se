---
version: 8.0.1
module: https://talend.poolparty.biz/coretaxonomy/42
product:
- https://talend.poolparty.biz/coretaxonomy/183
- https://talend.poolparty.biz/coretaxonomy/23
---

# TPS-5506

| Info             | Value                               |
| ---------------- |-------------------------------------|
| Patch Name       | Patch\_20230515\_TPS-5506\_v1-8.0.1 |
| Release date     | 2023-05-15                          |
| Target version   | 20211109\_1610-8.0.1                |
| Product affected | Talend Studio                       |

## Introduction

This is a self-contained patch.

**NOTE**: For information on how to obtain this patch, reach out to your Support contact at Talend.

## Fixed issues

This patch contains the following fix:

- TDI-49752 [8.0.1] tMap performance issue after migration to v8.0



## Prerequisites

Consider the following requirements for your system:

- Must install Talend Studio 8.0.1 with the monthly released patch, Patch\_20230421\_R2023-04\_v1-8.0.1.zip.
- Or must update the Talend Studio 8.0.1 with the URL, https://update.talend.com/Studio/8/updates/R2023-04/.

## Installation

Installation On Studio:

1. Shut down Talend studio if it is opened.
2. Extract the zip.
3. Merge the folder "plugins"  and its content to "{studio}/plugins" and overwrite the existing files.
4. remove the folder "{studio}/configuration/org.eclipse.osgi".
5. Start the Talend studio.
6. Rebuild your jobs.
