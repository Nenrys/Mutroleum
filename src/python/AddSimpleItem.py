import pyautogui as pgui
import shutil
import os

def writetomoditems(itemname):
    itemstring = "\tpublic static final RegistryObject<Item> " + itemname.upper() + \
                 " = ITEMS.register(\"" + itemname + "\", " + \
                 "\n\t\t() -> new Item(new Item.Properties().tab(ModCreativeModeTab.MUTROLEUM_TAB)));\n"

    newlinelist = []

    path = os.path.realpath(os.path.join(os.path.dirname(__file__), '..', 'main', 'java', 'com', 'nenrys', 'mutroleum',
                                         'item', 'ModItems.java'))
    with open(path, 'r') as javafile:
        lines = javafile.readlines()

        for line in lines:

            newlinelist.append(line)

            if '__0__' in line:
                newlinelist.append(itemstring)

    with open(path, 'w') as javafile:
        javafile.writelines(line for line in newlinelist)

def writelang(codename, actualname):
    itemstring = "  \"item.mutroleum." + codename + "\": \"" + actualname + "\",\n"

    newlinelist = []

    path = os.path.realpath(os.path.join(os.path.dirname(__file__), '..', 'main', 'resources', 'assets',
                                         'mutroleum', 'lang', 'en_us.json'))

    with open(path, 'r') as javafile:
        lines = javafile.readlines()

        for line in lines:

            newlinelist.append(line)

            if '__0__' in line:
                newlinelist.append(itemstring)

    with open(path, 'w') as javafile:
        javafile.writelines(line for line in newlinelist)

def copymodel(mname):
    copyfile = os.path.realpath(os.path.join(os.path.dirname(__file__), '..', 'main', 'resources', 'templates',
                                             'ItemModelTemplate.json'))
    pastefile = os.path.realpath(os.path.join(os.path.dirname(__file__), '..', 'main', 'resources', 'assets',
                                              'mutroleum', 'models', 'item', mname + '.json'))

    newlinelist = []

    with open(copyfile, 'r') as jsonfile:
        lines = jsonfile.readlines()

        for line in lines:
            line = line.replace("__0__", mname)
            newlinelist.append(line)

    with open(pastefile, 'w') as jsonfile:
        jsonfile.writelines(newlinelist)

def copytexture(tname):
    copyfile = os.path.realpath(os.path.join(os.path.dirname(__file__), '..', 'main', 'resources', 'templates',
                                             'TextureTemplate.png'))
    pastefile = os.path.realpath(os.path.join(os.path.dirname(__file__), '..', 'main', 'resources', 'assets',
                                              'mutroleum', 'textures', 'item', tname + '.png'))
    shutil.copyfile(copyfile, pastefile)


if __name__ == '__main__':
    codenm = pgui.prompt("Choose codename:")
    actualnm = pgui.prompt("Choose actual name")

    if codenm != '0':
        writetomoditems(codenm)
        writelang(codenm, actualnm)
        copymodel(codenm)
        copytexture(codenm)
