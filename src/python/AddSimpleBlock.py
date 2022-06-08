import pyautogui as pgui
import shutil
import os


def writetomodblocks(blockname):
    itemstring = "\tpublic static final RegistryObject<Block> " + blockname.upper() + \
                 " = registerBlock(\"" + blockname + "\", " + \
                 "\n\t\t    () -> new Block(BlockBehaviour.Properties.of(Material.STONE)), " \
                 "ModCreativeModeTab.MUTROLEUM_TAB);\n"

    newlinelist = []

    path = os.path.realpath(os.path.join(os.path.dirname(__file__), '..', 'main', 'java', 'com', 'nenrys', 'mutroleum',
                                         'block', 'ModBlocks.java'))

    with open(path, 'r') as javafile:
        lines = javafile.readlines()

        for line in lines:

            newlinelist.append(line)

            if '__0__' in line:
                newlinelist.append(itemstring)

    with open(path, 'w') as javafile:
        javafile.writelines(line for line in newlinelist)


def copyblockstates(statename):
    copyfile = os.path.realpath(os.path.join(os.path.dirname(__file__), '..', 'main', 'resources', 'templates',
                                             'BlockstateTemplate.json'))
    pastefile = os.path.realpath(os.path.join(os.path.dirname(__file__), '..', 'main', 'resources', 'assets',
                                              'mutroleum', 'blockstates', statename + '.json'))

    newlinelist = []

    with open(copyfile, 'r') as jsonfile:
        lines = jsonfile.readlines()

        for line in lines:
            line = line.replace("__0__", statename)
            newlinelist.append(line)

    with open(pastefile, 'w') as jsonfile:
        jsonfile.writelines(newlinelist)


def copyblockmodel(modelname):
    copyfile = os.path.realpath(os.path.join(os.path.dirname(__file__), '..', 'main', 'resources', 'templates',
                                             'BlockModelTemplate.json'))
    pastefile = os.path.realpath(os.path.join(os.path.dirname(__file__), '..', 'main', 'resources', 'assets',
                                              'mutroleum', 'models', 'block', modelname + '.json'))
    newlinelist = []

    with open(copyfile, 'r') as jsonfile:
        lines = jsonfile.readlines()

        for line in lines:
            line = line.replace("__0__", modelname)
            newlinelist.append(line)

    with open(pastefile, 'w') as jsonfile:
        jsonfile.writelines(newlinelist)


def copyitemblockmodel(modelname):
    copyfile = os.path.realpath(os.path.join(os.path.dirname(__file__), '..', 'main', 'resources', 'templates',
                                             'ItemBlockModelTemplate.json'))
    pastefile = os.path.realpath(os.path.join(os.path.dirname(__file__), '..', 'main', 'resources', 'assets',
                                              'mutroleum', 'models', 'item', modelname + '.json'))
    newlinelist = []

    with open(copyfile, 'r') as jsonfile:
        lines = jsonfile.readlines()

        for line in lines:
            line = line.replace("__0__", modelname)
            newlinelist.append(line)

    with open(pastefile, 'w') as jsonfile:
        jsonfile.writelines(newlinelist)


def copyblocktexture(tname):
    copyfile = os.path.realpath(os.path.join(os.path.dirname(__file__), '..', 'main', 'resources', 'templates',
                                             'BlockTextureTemplate.png'))
    pastefile = os.path.realpath(os.path.join(os.path.dirname(__file__), '..', 'main', 'resources', 'assets',
                                              'mutroleum', 'textures', 'block', tname + '.png'))
    shutil.copyfile(copyfile, pastefile)


def writelang(codename, actualname):
    itemstring = "  \"block.mutroleum." + codename + "\": \"" + actualname + "\",\n"

    newlinelist = []

    path = os.path.realpath(os.path.join(os.path.dirname(__file__), '..', 'main', 'resources', 'assets',
                                         'mutroleum', 'lang', 'en_us.json'))

    with open(path, 'r') as javafile:
        lines = javafile.readlines()

        for line in lines:

            newlinelist.append(line)

            if '__1__' in line:
                newlinelist.append(itemstring)

    with open(path, 'w') as javafile:
        javafile.writelines(line for line in newlinelist)


if __name__ == '__main__':
    codenm = pgui.prompt("Choose codename:")
    actualnm = pgui.prompt("Choose actual name")

    if codenm != '0':
        writetomodblocks(codenm)
        copyblockstates(codenm)
        copyblockmodel(codenm)
        copyitemblockmodel(codenm)
        copyblocktexture(codenm)
        writelang(codenm, actualnm)
