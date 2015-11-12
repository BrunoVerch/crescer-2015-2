using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Optimization;

namespace Locadora.Web.MVC.App_Start
{
    public class BundleConfig
    {
        public static void RegisterBundles(BundleCollection bundles)
        {
            bundles.Add(new ScriptBundle("~/bundles/jquery").Include(
                        "~/Scripts/jquery-{version}.js",
                        "~/Scripts/jquery-ui-{version}.js"));

            bundles.Add(new ScriptBundle("~/bundles/modernizr").Include(
                        "~/Scripts/modernizr-*"));

            bundles.Add(new ScriptBundle("~/bundles/bootstrap").Include(
                        "~/Scripts/bootstrap.js"));

            bundles.Add(new ScriptBundle("~/bundles/jquery-validator").Include(
                        "~/Scripts/jquery.validate.js",
                        "~/Scripts/jquery.validate.unobtrusive.js"));

            bundles.Add(new StyleBundle("~/Content/css").Include(
                        "~/Content/bootstrap.css",
                        "~/Content/Site.css",
                        "~/Content/Modules.css"));

            bundles.Add(new StyleBundle("~/Content/themes/base").IncludeDirectory(
                        "~/Content/themes/base/", "*.css", true));
        }
    }
}