package me.codeminions.secread.frags.Home;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.View;

import me.codeminions.common.Fragment;
import me.codeminions.common.adapter.FragmentAdapter;
import me.codeminions.common.view.VerticalViewPager;
import me.codeminions.secread.R;
import me.codeminions.secread.frags.ArticleFragment;

// TODO: 19-4-11 标题栏等 点击一次回收 再点击出现 
public class RecommendFragment extends Fragment {

    VerticalViewPager viewPager;
    FragmentAdapter adapter;

    private String[] articleList = {"", "电饭煲纳斯达克", "对付恐怖理发店看不见", "", "搞定了健康更不能离开", "欧体然后添加头你热"};

    @Override
    protected void initWidget(View root) {
        super.initWidget(root);

        articleList[0] = content.data1;
        articleList[3] = content.data2;

        viewPager = root.findViewById(R.id.vertical_pager);

        adapter = new FragmentAdapter(getChildFragmentManager(), articleList) {
            @Override
            public Fragment getItem(final int i) {
                final ArticleFragment currentFrag = new ArticleFragment();
                currentFrag.setOnInitContent(new ArticleFragment.OnInitContent() {
                    @Override
                    public void onInitContent() {
                        currentFrag.setText(getDataItem(i));
                    }
                });
                return currentFrag;
            }
        };


        viewPager.setAdapter(adapter);
        viewPager.setPageTransformer(true, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(@NonNull View view, float position) {
                // 删去这行会出现滑动时pager对角变换
                view.setTranslationX(view.getWidth() * -position);
                float y = position * view.getHeight();
                view.setTranslationY(y);
            }
        });
        viewPager.setCurrentItem(0);
    }

    @Override
    public int getContentId() {
        return R.layout.fragment_recommond;
    }


    static class content{
        static String data1 = "作者：王新喜\n" +
                "        链接：https://zhuanlan.zhihu.com/p/62202598\n" +
                "        来源：知乎\n" +
                "        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。\n" +
                "\n" +
                "        文/王新喜\n" +
                "        日前，华为P30系列新机在国内已正式发布，让笔者颇为关注的一个动作是，华为在新机上首发了EMUI9.1系统。EMUI9.1带来了两大黑科技突破，一是拿出了新的华为超级文件系统（EROFS），一是方舟编译器带来的全新系统及应用的编译和运行机制。而华为EMUI9.1在系统层面的突破，或是它对下一阶段的战略破局做铺垫。\n" +
                "        越用越慢在过去是Android手机的顽疾，而Android原生系统或改动不大的安卓系统，适用于国外的软件环境但在国内水土不服。过去几年，众多国产厂商的OS都基于Android上层界面修改，对安卓系统的性能、体验做改进，但很长一段时间以来，对系统底层动刀的厂商不多，尽管安卓手机在厂商的努力下，使用体验早已不是当年的塑料感，但与iOS叫板，依然有些底气不足。\n" +
                "        如果我们关注到近年来华为在Android手机的系列底层的动作会发现，华为对Android系统底层动刀的决心与能力要强过其他厂商。\n" +
                "        \n" +
                "        华为突破Android系统性能边界的执念很深\n" +
                "        \n" +
                "        Android系统发展到今天，在体验层面与多年前已不可同日而语。自2005年以来，已有超过1400家公司为Android系统的内核Linux做出了贡献。而三星与华为则深入参与到了整个Android系统从基础代码到最终成型的过程之中。据2017的Linux内核开发报告指出，有500多家公司的4300多名开发商对内核做出了贡献， Linux内核代码，谷歌贡献度是3%，而华为占1.5%。\n" +
                "        华为对系统底层技术的研发也赋予到自家的EMUI优化。2016年的EMUI5.0中提出\"天生快，一生快\"是基于华为AI自学习系统，以及软硬结合的精细化资源调度和安卓系统组件深入优化等一系列技术的组合，希望将Android系统变成\"抽屉式可替换\"架构。\n" +
                "        2018年，华为EMUI8.1拿出了GPU Turbo技术，打通了EMUI操作系统以及GPU和CPU之间的处理瓶颈——针对GPU和CPU两者抢夺TDP的功耗问题，在系统底层对传统的图形处理框架进行了重构，实现了软硬件协同，使得图形运算整体效率提升60%，芯片的功耗降低30%。当前在华为EMUI9.1中，GPU Turbo达成了接近满帧高画质的游戏运行体验，带动了功耗节省等层面的性能提升。\n" +
                "        当前EMUI9.1也在原有基础上进一步突破Android系统性能边界，它采用了自研的华为超级文件系统（EROFS），这是继之前率先应用F2FS文件系统之后的又一重大革新，数据显示，它实现20%的随机读性能提升，使系统及应用启动和运行的速度得到显著提升。\n" +
                "        F2FS文件系统在2016年已经在华为EMUI 5.0中首发商用，当时应用F2FS目的在于减少内存中长时间的读取的碎片化，它替代了传统的EXT4文件系统，改善了闪存长期使用后的读写性能。后来在2018年，谷歌也在自己的旗舰Pixel 3中使用了F2FS，其他的厂商也全面使用了F2FS。\n" +
                "        某种程度上，过去的F2FS文件系统解决了安卓用户分区（相当于电脑的D盘）在长时间使用后的读写性能问题，而当前EMUI9.1的EROFS文件系统则是提升了Android分区（相当于电脑的C盘）的随机读取性能，从系统底层提升运行效率，实现20%的随机读取性能提升，是在Android系统运行的持久流畅度层面又一次突破。此前华为在巴黎发布会上秀了一把EMUI9.1带来的流畅体验，依次启动Google Play法国排行榜的Top15应用，P30 Pro比iPhone XS Max平均每个应用启动时间快1秒以上。\n" +
                "        其次是，华为方舟编译器提供了全新的系统及应用的编译和运行机制，从动态编译变为静态编译，就是将高级语言直接编译成机器码，彻底消除了虚拟机动态编译的额外开销，实现了开发和运行效率的兼容并举。\n" +
                "        从GPU Turbo、华为超级文件系统（EROFS）、方舟编译器机制的简化，可以看到对Android系统底层的优化几乎成了华为的执念，但华为的这层执念也让其在Android性能的革新层面带来了持续性的突破，也给华为打破Android的基因软肋创造了新的机会。\n" +
                "        \n" +
                "        克服Android的基因软肋，能否与iOS站到同一起跑线？\n" +
                "        \n" +
                "        Android的基因软肋在于，它的系统底层则是基于虚拟机机制的玩法。去年余承东也批评Android采用Java虚拟机转码的做法，因为安卓系统基于开源适配不同硬件的需求，需要加入虚拟机去跑，虚拟机机制大幅度降低硬件和软件的数据交换效率，造成安卓系统流畅性不耐久，牺牲硬件和软件的数据交换效率导致变慢。\n" +
                "        现在华为EMUI9.1的做法其实与苹果非常接近。\n" +
                "        苹果的iOS系统带来的流畅易用快速体验给它带来了品牌溢价的加持，这根源于iOS系统的编译器原理与Android不同，iOS从诞生之初就采用LLVM编译器，它提供了一种代码编写良好的中间表示IR，作为多种语言的后端，能提供与变成语言无关的优化与针对多种 CPU 的代码生成功能，即将应用程序（Swift语言编写）提前编译成机器码，直接运行在芯片上，应用运行变得高效。\n" +
                "        而Android虽采用了开发效率更高的Java作为编程语言，但由于Java语言独特的虚拟机机制（简称JVM），在运行时才将应用程序的Java字节码即时编译为机器码，边翻译边执行，执行效率与iOS有了差距。iOS与Android系统的体验差距在于iOS没有JVM——虚拟机机制。\n" +
                "        采用方舟编译器也即意味着，应用程序在开发阶段就已经完成了编译，用户从华为应用市场下载的APK就是编译过的机器码了。虽然采用静态编译方式后安装文件的大小可能会有所增加，但应用安装完成后安装文件便会被删除，安装后所占用的空间与原来相差无几，同时目前手机的存储配置足够大，用户大可不必担心存储空间的问题。\n" +
                "        方舟编译器是对安卓平台的一项重大革新，它相当于在安卓底层大换血或者开刀，将虚拟机拿掉，克服了Android基因层面的软肋，开发者在开发环境一次性的将高级语言编译为机器码，提升执行性能，使持久流畅的体验变得可期。\n" +
                "        华为方舟编译器据说会在今年内全面开源。余承东也在发布会上呼吁APP开发者尽快使用。而新浪微博极速版参与了应用方舟编译器的测试，根据华为实验室测试数据显示，操作流畅度提升高达60%。\n" +
                "        \n" +
                "        从全面技术积累的角度，能够有实力对安卓底层开刀的或许就剩下谷歌与华为了，而谷歌自然基于其开放战略不愿动手，从华为拿掉虚拟机的做法来看，一方面它是要探索Android系统性能的新边界，建立系统底层的AI技术护城河——华为超级文件系统、GPU Turbo 3.0、底层编译技术等一系列突破都是依托于底层系统能力与AI的驱动。一个判断是，在系统底层的深入改造水平会决定厂商未来技术对决与品牌高度的差异，厂商之间的核心技术与销量走向也将与此成正相关。其二，华为想在系统体验与iOS站到同一起跑线，在5G 时代与苹果在核心层面进行对决。\n" +
                "        \n" +
                "        5G时代，华为与苹果的下半场之争\n" +
                "        \n" +
                "        苹果在5G时代会面临更大的压力。\n" +
                "        \n" +
                "        这基于两点原因，其一，华为将其在系统级层面的优化能力与技术开源，反哺整个Android领域，例如F2FS文件系统，Vulkan图形引擎等，方舟编译器、超级文件系统开源并合入Linux内核主线，带动整个Android行业阵营的系统体验改善，这其实挤压了iOS的优势阵地。因为这意味着在Android阵营头部厂商，无论是在硬件性能层面还是软件系统层面与苹果的差距将进一步缩小。\n" +
                "        其二，占有5G技术专利优势其实给华为未来5G手机带来了技术先发优势，但苹果当前缺失了5G基带芯片，在通信技术专利层面存在着短板。而5G支持低延迟和大容量的 GB 级、更快的网络与速度，带来更高的清晰度和更流畅快速的体验，5G时代是手机厂商的IoT时代，配合Android系统底层的开刀优化，苹果iOS这张王牌的效力可能在5G时代没那么明显了。\n" +
                "        因此，华为是在5G时代做铺垫，比如华为P30系列的IoT战略非常明显，从它的AI应用——华为智慧剪辑、手机跑步机互联、Huawei Share 一碰传、手机车钥匙等思路来看，它要将手机打造成以手机为中心的多设备全产品连接器。未来基于5G芯片适配强大的软件引擎，从软硬件层面的双向融合、抹平系统层面的差距，可能是华为在系统底层动刀的战略目的——在系统体验层面有必要与苹果一战。而华为当前突破安卓虚拟机编译效率低的问题，对标对象可能是苹果，因为华为本身是一家有野心的厂商，它不愿意一直被困在系统这一层的短板。\n" +
                "        \n" +
                "        综上所述，iOS是支撑苹果品牌溢价的王牌，但5G时代配合Android系统体验的优化，系统体验差距逐步弥合是一种大势，在5G大潮下Android手机还有弯道超车的机会，华为与苹果在5G时代的下半场之争，还有的看。\n" +
                "        作者：王新喜 TMT资深评论人 本文未经许可谢绝转载 我的微信公众号：热点微评（redianweiping）";

        static String data2 = "经典之所以流传不仅仅是反映了她当时的时代更是写出了人性。\n" +
                "傲慢与偏见写的是一本账单里的爱情。\n" +
                "达西先生年收入一万英镑。\n" +
                "宾利先生年收入五千英镑。\n" +
                "柯林斯先生将会从他的表亲那里继承每年两千磅的财产。\n" +
                "班纳特姐妹只能有五千磅的嫁妆。\n" +
                "班纳特太太的嫁妆也只是四千磅。\n" +
                "宾利小姐有着两万磅的嫁妆，觉得自己更有资格嫁给达西先生。\n" +
                "达西小姐有着五万的嫁妆，险些被诱拐私奔。\n" +
                "达西先生的表哥直接说没有三万英镑嫁妆的女性不在他的考虑范围。\n" +
                "这个现象在今天依旧是如此。\n" +
                "\n" +
                "作者：李小喵\n" +
                "链接：https://www.zhihu.com/question/46266991/answer/636790968\n" +
                "来源：知乎\n" +
                "著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。";
    }

}
